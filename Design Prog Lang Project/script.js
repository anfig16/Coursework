const currentDate = new Date();
var currentMonth = currentDate.getMonth(); // Get current month (0-11)
var currentYear = currentDate.getFullYear(); // Get current year;
var totalMonthDays = 0;
var eventsList = [];  //store events inputted
var notesList = [];  //store notes inputted

//Function to generate the calendar for the current month
function generateCalendar() {
    var firstDayOfMonth = new Date(currentYear, currentMonth, 1).getDay(); //Get first day of the month (0-6, Sunday-Saturday)
    var totalDaysInMonth = new Date(currentYear, currentMonth + 1, 0).getDate(); //Get the total number of days in the month
    totalMonthDays = totalDaysInMonth;
    const monthNames = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"];

    //Update the month-year display
    const monthYearDisplay = document.getElementById("month-year");
    monthYearDisplay.textContent = monthNames[currentMonth] + " " + currentYear;

    //Get all the column elements where days will be inserted
    const columns = document.querySelectorAll('.days-grid .column');

    //Clear any previous days in the calendar (only for <h2> elements)
    columns.forEach(col => {
        const h2 = col.querySelector('h2');  //Find the <h2> inside each column
        if (h2) {
            h2.innerHTML = '';  //Clear the existing content in h2
        }
    });

    //Insert the correct day numbers into the h2 elements
    let day = 1;

    //Start filling the calendar from the correct starting point day
    for (let i = firstDayOfMonth; i < columns.length && day <= totalDaysInMonth; i++) {
        const h2 = columns[i].querySelector('h2');  //Find h2 element in the column
        if (h2) {
            h2.innerHTML = day;  //Insert the day number inside h2
        }
        day++;
    }
    
    //Puts blank placeholders in h2 in unused days to preserve spacing
    for(let i = 0; i < columns.length ; i++) {
        const h2 = columns[i].querySelector('h2');  //Find the <h2> element in the column
        const h2Value = h2.textContent;
        if (h2Value === '') {
            h2.innerHTML = "&nbsp;";  //Insert blank space/empty h2
        }
    }

    //Puts blank placeholders in p in empty days to preserve spacing
    for(let i = 0; i < columns.length ; i++) {
        const p = columns[i].querySelector('p');  // Find the <p> element in the column
        const pValue = p.textContent;
        if (pValue) {
            p.innerHTML = "";  //Clears out all event buttons from p
        }
    }

    //Check if any events needed to display
    displayEvents();
}

//User inputs an event
function userInputEvent(event) {
    //Prevent the form from submitting and refreshing the page
    event.preventDefault();

    //Gets the user inputted date
    var date = document.getElementById('date').value;

    //Gets the user inputted event title
    var eventInfo = document.getElementById('eventInfo').value;

    //Gets the user inputted event description
    var eventDesc = document.getElementById('eventDescription').value;

    const dateParts = date.split('/');

    //Just in case check that dateParts has 3 parts: month, day, year
    if (dateParts.length == 3) {
        //Convert user input into integers
        const month = parseInt(dateParts[0]);
        const day = parseInt(dateParts[1]);
        const year = parseInt(dateParts[2]);

        //Checks if the user-inputted date is valid
        if (isValidDate(month, day, year)) {
            //Clear any error messages that might've popped up
            var errorMes = document.getElementById('errorMessage');
            errorMes.textContent = '';
        } else {
            //Date is invalid, show error message
            var errorMes = document.getElementById('errorMessage');
            errorMes.textContent = 'Invalid month or day entered. Please try again.';
            return;
        }
    } else {
        //Wrong date format, show error message
        var errorMes = document.getElementById('errorMessage');
        errorMes.textContent = 'Invalid date format; Please use MM/DD/YYYY.';
        return;
    }
    

    //add event to calendar
    addToCalendar(dateParts, eventInfo, eventDesc);
}

function addToCalendar(dateParts, eventInfo, eventDesc) {

    var month = dateParts[0];
    var day = dateParts[1];
    var year = dateParts[2];

    //saves the entered event
    eventsList.push([month, day, year, eventInfo, eventDesc]);
    localStorage.setItem('events', JSON.stringify(eventsList));

    //if the date for event is in current view, regenerate calendar to reflect added event
    if((currentMonth+1) == month && currentYear == year) {
        displayEvents();
    } 

    //clears text input from boxes
    document.getElementById("date").value = "";
    document.getElementById("eventInfo").value = "";
    document.getElementById("eventDescription").value = "";
}

//actually display events on current displayed calendar month
function displayEvents() {

    //Connect to columns/days in calendar
    const columns = document.querySelectorAll('.days-grid .column');

    //Clear previous buttons displayed in the calendar
    columns.forEach(column => {
        const p = column.querySelector('p');
        if (p) {
            p.innerHTML = ""; //Clears the previously displayed buttons (buttons inside element p)
        }
    });

    //Goes through the eventsList to display the relevant events
    for (let y = 0; y < eventsList.length; y++) {
        const [eventMonth, eventDay, eventYear, eventInfo, eventDesc] = eventsList[y];

        //Checks if the event is in the current displayed month and year
        if ((currentMonth + 1) === parseInt(eventMonth) && currentYear === parseInt(eventYear)) {
            // Find the matching column for the day
            for (let x = 0; x < columns.length; x++) {
                const h2 = columns[x].querySelector('h2'); //Get day number
                if (h2 && h2.textContent === String(parseInt(eventDay))) {
                    const p = columns[x].querySelector('p'); //Get <p> attribute of correct day
                    if (p) {
                        // Create the event button
                        const eventButton = document.createElement('button');
                        eventButton.textContent = eventInfo;
                        //If no event title inputted, display date on event button
                        if (eventInfo == "" || eventInfo == null) {
                            eventButton.textContent = eventMonth + "/" + eventDay + "/" + eventYear;
                        }
                        //styling
                        eventButton.style.maxWidth = "150px";
                        eventButton.style.whiteSpace = "nowrap";
                        eventButton.style.overflow = "hidden"; 
                        eventButton.style.marginLeft = "7px";

                        //Add event listener
                        eventButton.addEventListener('click', () => eventClicked(eventMonth, eventDay, eventYear, eventInfo, eventDesc));

                        //Append  eventButton to the <p> element (so button is displayed inside correct day)
                        p.appendChild(eventButton);

                        //Line break after the event button (each button on own line)
                        const brElement = document.createElement('br');
                        p.appendChild(brElement);
                    }
                    break;
                }
            }
        }
    }

}

//when event on calendar clicked, opens pop-up with event info on it
function eventClicked(eventMonth, eventDay, eventYear, eventInfo, eventDesc) {
    //Semi-transparent background overlay (overcast part behind pop-up)
    const overlay = document.createElement('div');
    overlay.classList.add('popup-overlay');
    overlay.style.position = 'fixed';
    overlay.style.top = '0';
    overlay.style.left = '0';
    overlay.style.width = '100vw';
    overlay.style.height = '100vh';
    overlay.style.backgroundColor = 'rgba(0, 0, 0, 0.5)';
    overlay.style.display = 'flex';
    overlay.style.justifyContent = 'center';
    overlay.style.alignItems = 'center';
    overlay.style.zIndex = '1000';

    //Pop-up container
    const popup = document.createElement('div');
    popup.classList.add('popup-container');
    popup.style.width = '300px';
    popup.style.padding = '20px';
    popup.style.backgroundColor = 'white';
    popup.style.borderRadius = '10px';
    popup.style.boxShadow = '0 4px 8px rgba(0, 0, 0, 0.2)';
    popup.style.textAlign = 'center';

    //Add the event information to the popup
    const title = document.createElement('h2');
    title.textContent = eventInfo;
    title.style.marginBottom = '10px';
    title.style.maxWidth = '80vw';
    title.style.wordBreak = "break-all";
    title.style.whiteSpace = "normal";
    
    popup.appendChild(title);

    const info = document.createElement('p');
    info.textContent = eventMonth + "/" + eventDay + "/" + eventYear;
    info.style.fontWeight = 'bold';
    info.style.marginBottom = '10px';
    info.style.maxWidth = '80vw';
    info.style.wordBreak = "break-all";
    info.style.whiteSpace = "normal";
    popup.appendChild(info);

    //checks if description for event was added or not
    if (eventDesc) {
        const desc = document.createElement('p');
        desc.textContent = eventDesc;
        desc.style.marginBottom = '15px';
        desc.style.maxWidth = '80vw';
        desc.style.wordBreak = "break-all";
        desc.style.whiteSpace = "normal";
        popup.appendChild(desc);
    } else {
        const desc = document.createElement('p');
        desc.textContent = "No description available";
        desc.style.marginBottom = '15px';
        popup.appendChild(desc);
    }

    //Close button in popup
    const closeButton = document.createElement('button');
    closeButton.id = "closeButton";
    closeButton.textContent = 'Close';
    closeButton.style.padding = '10px 15px';
    closeButton.style.backgroundColor = '#7EB2DD';
    closeButton.style.color = '#0d1b2a';
    closeButton.style.border = 'none';
    closeButton.style.borderRadius = '5px';
    closeButton.style.cursor = 'pointer';

    //Eventlistener for close popup button
    closeButton.addEventListener('click', function () {
        document.body.removeChild(overlay); //Removes the actual popup 
    });
    popup.appendChild(closeButton);

    overlay.appendChild(popup);  //overlay has popup as child so that when button clicked both are removed

    document.body.appendChild(overlay); //add overlay/popup to index.html
}

//function for entering notes
function inputNotes() {
    //Prevent the form from submitting and refreshing the page
    event.preventDefault();

    //Gets the user inputted notes
    var notes = document.getElementById('notesInput').value;

    //Add notes if user input is not empty
    if(notes != "") {
        notesList.push(notes);
        localStorage.setItem('notes', JSON.stringify(notesList));
    }
    
    
    //clears text input from boxes
    document.getElementById("notesInput").value = "";

    displayNotes();
}

//function to display notes
function displayNotes() {
    //Connect to noteSection div
    const notesSection = document.querySelector('.notesSection');

    //Clear notes section
    notesSection.innerHTML = "";

    //For every user inputted note, display the note
    for (let y = 0; y < notesList.length; y++) {
        const notesP = document.createElement('p');
        notesP.textContent = notesList[y];
        //styling
        notesP.style.display = "list-item";
        notesP.style.wordBreak = "break-all";
        notesP.style.whiteSpace = "normal";

        notesSection.appendChild(notesP);
    }

}

//Function to validate the date
function isValidDate(month, day, year) {
    //Check for valid month
    if (month < 1 || month > 12) {
        return false;
    }

    //Get the total number of days in the month
    const totalDaysInMonth = new Date(year, month, 0).getDate();

    //Check for valid day
    if (day < 1 || day > totalDaysInMonth) {
        return false;
    }

    return true; //If both month and day are valid
}

//Function to change the month (prev or next buttons)
function changeMonth(direction) {
    if (direction == 1) {
        currentMonth -= 1;
        if (currentMonth < 0) { //If -1 (out of bounds, current month before clicking would be Jan), set to December of previous year
            currentMonth = 11; //December
            currentYear -= 1; //Previous year
        }
    } else if (direction == 2) {
        currentMonth += 1;
        if (currentMonth > 11) { //If 12 (out of bounds, 11 is Dec), set to January of next year
            currentMonth = 0; //January
            currentYear += 1;
        }
    }

    generateCalendar(); //Re-generate the calendar after the month change
}

//Function to clear all the saved data from local storage
function clearSavedData() {
    localStorage.removeItem('events'); //Clears all the events from localStorage
    eventsList = []; //Clears eventsList in memory
    localStorage.removeItem('notes'); //Clears all the notes from localStorage
    notesList = []; //Clears notesList in memory

    //Clear the event buttons from the current calendar view
    const columns = document.querySelectorAll('.days-grid .column');
    columns.forEach(column => {
        const p = column.querySelector('p');
        if (p) {
            p.innerHTML = "&nbsp;"; //Clears any event buttons
        }
    });

    //Clear notes section
    const notesSection = document.querySelector('.notesSection');
    notesSection.innerHTML = "";

    //When clear button clicked, reload page to display updates
    location.reload();

    const clearButton = document.getElementById('clearData');
    clearButton.click;
    location.reload();
    clearButton.click;

    generateCalendar(); //Re-generates the calendar
}


//Eventlistener for the clear saved data button
document.getElementById('clearData').addEventListener('click', clearSavedData);

//Eventlistener for notes submit button
document.getElementById('notesSubmit').addEventListener('click', inputNotes);

//Get the form element
var form = document.getElementById('eventForm');
//Eventlistener fpr the form for the submit event
form.addEventListener('submit', userInputEvent);

//Eventlisteners for prev and next month buttons
var preV = document.getElementById("Prev");
var next = document.getElementById("Next");

preV.addEventListener('click', () => changeMonth(1)); 
next.addEventListener('click', () => changeMonth(2));

//Event listener for edit/modify buttons
var editDeleteButton = document.getElementById("EditDelete");
editDeleteButton.addEventListener("click", function () {
    window.location.href = "events.html";
});
var editDeleteNotesButton = document.getElementById("EditDeleteNotes");
editDeleteNotesButton.addEventListener("click", function () {
    window.location.href = "events.html";
});


//storing user-inputted data on local storage
// On page load, retrieve events from localStorage
window.onload = () => {

    // Load saved events from localStorage
    const savedEvents = JSON.parse(localStorage.getItem('events'));
    const savedNotes = JSON.parse(localStorage.getItem('notes'));
    if (savedEvents && Array.isArray(savedEvents)) {
        eventsList = savedEvents; // Update the eventsList with saved events
    }
    if (savedNotes && Array.isArray(savedNotes)) {
        notesList = savedNotes; // Update notesList with saved notes
    }
    
    // Generate the calendar and display events
    generateCalendar();
    displayNotes();
};
