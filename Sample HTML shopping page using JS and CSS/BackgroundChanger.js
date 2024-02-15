// JavaScript code to change the background color
function changeBackgroundColor() {
    // Generate a random color
    const randomColor = '#' + Math.floor(Math.random()*16777215).toString(16);

    // Set the body background color
     document.body.style.backgroundColor = randomColor;
    }

// Call the function when the page is loaded
window.addEventListener('load', changeBackgroundColor);