// Global variables
let display = document.getElementById('display');
let expression = document.getElementById('expression');
let historyList = document.getElementById('history');
let currentExpression = '0';
let previousValue = '';
let currentOperator = '';
let history = [];

// Initialize display
function initDisplay() {
    updateDisplay();
    updateHistory();
}

// Update display
function updateDisplay() {
    display.value = currentExpression;
    expression.textContent = previousValue + ' ' + currentOperator;
}

// Append number to display
function appendNumber(num) {
    if (currentExpression === '0' && num !== '.') {
        currentExpression = num;
    } else if (num === '.' && currentExpression.includes('.')) {
        return;
    } else if (currentExpression.length < 15) {
        currentExpression += num;
    }
    updateDisplay();
}

// Append operator
function appendOperator(op) {
    if (currentExpression === '' || currentExpression === '0') return;

    if (previousValue === '') {
        previousValue = currentExpression;
        currentOperator = op;
        currentExpression = '';
    } else if (currentOperator !== '') {
        // Calculate the current result first
        calculate();
        currentOperator = op;
    }
    updateDisplay();
}

// Delete last character
function deleteLastChar() {
    if (currentExpression.length > 1) {
        currentExpression = currentExpression.slice(0, -1);
    } else {
        currentExpression = '0';
    }
    updateDisplay();
}

// Clear display
function clearDisplay() {
    currentExpression = '0';
    previousValue = '';
    currentOperator = '';
    updateDisplay();
}

// Calculate result
function calculate() {
    if (previousValue === '' || currentOperator === '' || currentExpression === '') {
        return;
    }

    const num1 = parseFloat(previousValue);
    const num2 = parseFloat(currentExpression);

    // Call backend API
    fetch('/api/calculator/calculate', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded',
        },
        body: new URLSearchParams({
            'num1': num1,
            'num2': num2,
            'operation': currentOperator
        })
    })
    .then(response => response.json())
    .then(data => {
        if (data.success) {
            const result = data.result;
            addToHistory(`${num1} ${currentOperator} ${num2} = ${result}`);
            currentExpression = result.toString();
            previousValue = '';
            currentOperator = '';
            updateDisplay();
        } else {
            alert('Error: ' + data.error);
            clearDisplay();
        }
    })
    .catch(error => {
        console.error('Error:', error);
        alert('Connection error. Please try again.');
    });
}

// Perform advanced operations
function advancedOperation(operation) {
    if (currentExpression === '' || currentExpression === '0') return;

    const num = parseFloat(currentExpression);

    fetch('/api/calculator/advanced', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded',
        },
        body: new URLSearchParams({
            'number': num,
            'operation': operation
        })
    })
    .then(response => response.json())
    .then(data => {
        if (data.success) {
            const result = data.result;
            let opSymbol = operation === 'sqrt' ? '√' : (operation === 'square' ? '²' : '1/');
            addToHistory(`${opSymbol}(${num}) = ${result}`);
            currentExpression = result.toString();
            previousValue = '';
            currentOperator = '';
            updateDisplay();
        } else {
            alert('Error: ' + data.error);
        }
    })
    .catch(error => {
        console.error('Error:', error);
        alert('Connection error. Please try again.');
    });
}

// Add to history
function addToHistory(entry) {
    history.unshift(entry);
    if (history.length > 20) {
        history.pop();
    }
    updateHistory();
    saveHistoryToLocalStorage();
}

// Update history display
function updateHistory() {
    if (history.length === 0) {
        historyList.innerHTML = '<div class="history-empty">No history yet</div>';
        return;
    }

    historyList.innerHTML = '';
    history.forEach((item, index) => {
        const historyItem = document.createElement('div');
        historyItem.className = 'history-item';
        historyItem.textContent = item;
        historyItem.onclick = () => {
            const result = parseFloat(item.split('=')[1].trim());
            if (!isNaN(result)) {
                currentExpression = result.toString();
                previousValue = '';
                currentOperator = '';
                updateDisplay();
            }
        };
        historyList.appendChild(historyItem);
    });
}

// Clear history
function clearHistory() {
    if (confirm('Are you sure you want to clear the history?')) {
        history = [];
        updateHistory();
        localStorage.removeItem('calculatorHistory');
    }
}

// Save history to localStorage
function saveHistoryToLocalStorage() {
    localStorage.setItem('calculatorHistory', JSON.stringify(history));
}

// Load history from localStorage
function loadHistoryFromLocalStorage() {
    const savedHistory = localStorage.getItem('calculatorHistory');
    if (savedHistory) {
        history = JSON.parse(savedHistory);
        updateHistory();
    }
}

// Initialize on page load
window.addEventListener('DOMContentLoaded', () => {
    initDisplay();
    loadHistoryFromLocalStorage();
});

// Keyboard support
document.addEventListener('keydown', (e) => {
    if (e.key >= '0' && e.key <= '9') appendNumber(e.key);
    if (e.key === '.') appendNumber('.');
    if (e.key === '+' || e.key === '-' || e.key === '*' || e.key === '/') appendOperator(e.key);
    if (e.key === 'Enter') calculate();
    if (e.key === 'Backspace') deleteLastChar();
    if (e.key === 'Escape') clearDisplay();
});
