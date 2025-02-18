function displayAllEvents() {
    //Get the stored events list from localStorage
    const storedEvents = localStorage.getItem('events');
    //Get the container where events will be displayed on page
    const eventListContainer = document.getElementById('eventsList');
    //Clear out any previously displayed content
    eventListContainer.innerHTML = "";

    if (storedEvents) {
        try {
            const eventsList = JSON.parse(storedEvents);

            // Check if eventsList is a valid array with at least one valid event
            if (Array.isArray(eventsList) && eventsList.length > 0) {  //check if events exists
                let hasValidEvents = false;

                //go through all stored events and display with edit/delte buttons
                eventsList.forEach(function(event, index) {
                    if (Array.isArray(event) && event.length >= 4 && event[1] != null) {  //check if event stored properly
                        hasValidEvents = true;

                        const month = event[0];
                        const day = event[1];
                        const year = event[2];
                        const eventInfo = event[3];
                        const eventDesc = event[4];
            
                        //Create a div container for each event (for buttons and event)
                        const singleEventContainer = document.createElement('div');
                        singleEventContainer.classList.add("singleEvent");
                        singleEventContainer.style.display = "flex";
                        eventListContainer.appendChild(singleEventContainer);
            
                        //Create a div container for the buttons (edit, delete)
                        const buttonEventContainer = document.createElement('div');
                        buttonEventContainer.classList.add("buttonEventContainer");
                        buttonEventContainer.style.display = "flex";
                        buttonEventContainer.style.marginRight = "10px"; 
                        singleEventContainer.appendChild(buttonEventContainer);
            
                        if (day != null) { // safeguard against event actually existing/saved correctly
                            //Edit button
                            const editButton = document.createElement('button');
                            editButton.classList.add("EditButton");
                            editButton.textContent = "Edit";
                            //styling
                            editButton.style.width = "40px";
                            editButton.style.height = "22px";
                            buttonEventContainer.appendChild(editButton);
            
                            //Delete button
                            const deleteButton = document.createElement('button');
                            deleteButton.classList.add("DeleteButton");
                            deleteButton.textContent = "Delete";
                            //styling
                            deleteButton.style.width = "54px";
                            deleteButton.style.height = "22px";
                            buttonEventContainer.appendChild(deleteButton);
            
                            //Eventlisteners for Edit and Delete buttons
                            editButton.addEventListener('click', function() {
                                editEvent(event, index, eventsList); 
                            });
                            deleteButton.addEventListener('click', function() {
                                deleteEvent(event, index, eventsList); 
                            });
            
                            //Add event date and title to single event containter
                            const dateTitle = document.createElement('p');
                            dateTitle.textContent = month + "/" + day + "/" + year + ": " + eventInfo;
                            //styling
                            dateTitle.style.fontWeight = "bold";
                            dateTitle.style.fontSize = "18px";
                            dateTitle.style.marginLeft = "10px";
                            dateTitle.style.marginBottom = "5px";
                            dateTitle.style.marginTop = "0px";
                            dateTitle.style.wordBreak = "break-all";
                            dateTitle.style.whiteSpace = "normal";
                            dateTitle.style.maxWidth = "300px";
                            singleEventContainer.appendChild(dateTitle);
            
                            //If event has description, add to single event container
                            if (eventDesc) {
                                const desc = document.createElement('p');
                                desc.textContent = eventDesc;
                                //styling
                                desc.style.paddingLeft = "110px";
                                desc.style.marginBottom = "15px";
                                desc.style.marginTop = "0px";
                                desc.style.maxWidth = "300px";
                                desc.style.wordBreak = "break-all";
                                desc.style.whiteSpace = "normal";
                                eventListContainer.appendChild(desc);
                            }
                        }
                    }
                });

                //If no valid events were found, display  message
                if (!hasValidEvents) {
                    const eventP = document.createElement('p');
                    eventP.textContent = "No valid events found in localStorage";
                    eventListContainer.appendChild(eventP);
                }

                return; //Exit the function since we handled valid events
            }
        } catch (error) {  //If somehow error, catch and display error message
            const errorM = document.createElement('p');
            errorM.textContent = "Error parsing events from localStorage";
            eventListContainer.appendChild(errorM);
        }
    }

    //If no events exist/stored, display the message
    const eventP = document.createElement('p');
    eventP.textContent = 'No events found in localStorage';
    eventListContainer.appendChild(eventP); 
}

//Function to edit an event
function editEvent(event, index, eventsList) {
    //Get the event to edit based on index
    const eventToEdit = eventsList[index];

    //Create form for user input for edits
    const formContainer = document.createElement('div');
    formContainer.classList.add('editFormContainer');

    const monthInput = document.createElement('input');
    monthInput.value = eventToEdit[0];  //displays current month before editing
    monthInput.placeholder = "Month";
    formContainer.appendChild(monthInput);

    const dayInput = document.createElement('input');
    dayInput.value = eventToEdit[1]; //displays current day before editing
    dayInput.placeholder = "Day";
    formContainer.appendChild(dayInput);

    const yearInput = document.createElement('input');
    yearInput.value = eventToEdit[2]; //displays current year before editing
    yearInput.placeholder = "Year";
    formContainer.appendChild(yearInput);

    const titleInput = document.createElement('input');
    titleInput.value = eventToEdit[3]; //displays current title before editing
    titleInput.placeholder = "Event Title";
    formContainer.appendChild(titleInput);

    const descInput = document.createElement('input');
    descInput.value = eventToEdit[4] || ""; //displays current month before editing or puts empty string if no description
    descInput.placeholder = "Event Description";
    formContainer.appendChild(descInput);

    //Submit button for form
    const submitButton = document.createElement('button');
    submitButton.textContent = "Save Changes";
    formContainer.appendChild(submitButton);

    const eventListContainer = document.getElementById('eventsList');
    eventListContainer.appendChild(formContainer);

    //Eventlistener for form submit button
    submitButton.addEventListener('click', function(event) {
        event.preventDefault(); //Prevent the form from refreshing the page

        //Update the event with the new values user inputted in the form
        eventToEdit[0] = monthInput.value;
        eventToEdit[1] = dayInput.value;
        eventToEdit[2] = yearInput.value;
        eventToEdit[3] = titleInput.value;
        eventToEdit[4] = descInput.value;

        //Save the updated events list back to localStorage
        localStorage.setItem('events', JSON.stringify(eventsList));

        //Re-display the events list
        displayAllEvents();

        //Remove the form after submitting edits
        eventListContainer.removeChild(formContainer);
    });
}

//Function to delete an event
function deleteEvent(event, index, eventsList) {
    //Remove the event from the eventsList (where all events stored)
    eventsList.splice(index, 1);

    //Save the updated events list back to localStorage
    localStorage.setItem('events', JSON.stringify(eventsList));

    //Re-display the events list
    displayAllEvents();
}

//Function to display all notes
function displayAllNotes() {
    //Retrieve the stored notes list from localStorage
    const storedNotes = localStorage.getItem('notes');
    //Get the container where events will be displayed
    const notesListContainer = document.getElementById('notesList');
    notesListContainer.innerHTML = ""; //Clear the notesListContainer just in case any updates

    //Check if there are any notes stored
    if (storedNotes) {
        //Parse JSON string back into an array
        const notesList = JSON.parse(storedNotes);

        //Go through the notes and display them
        notesList.forEach(function(note, index) {
            //Create a container for each note (to hold edit/delete buttons and note)
            const singleNoteContainer = document.createElement('div');
            singleNoteContainer.classList.add("singleNote");
            //styling
            singleNoteContainer.style.display = "flex";
            singleNoteContainer.style.alignItems = "center";
            notesListContainer.appendChild(singleNoteContainer);

            //Create a container for the buttons edit and delete
            const buttonNoteContainer = document.createElement('div');
            buttonNoteContainer.classList.add("buttonNoteContainer");
            //styling
            buttonNoteContainer.style.display = "flex";
            buttonNoteContainer.style.marginRight = "10px";
            singleNoteContainer.appendChild(buttonNoteContainer);

            //Edit button
            const editButton = document.createElement('button');
            editButton.classList.add("EditNoteButton");
            editButton.textContent = "Edit";
            //styling
            editButton.style.width = "40px";
            editButton.style.height = "22px";
            buttonNoteContainer.appendChild(editButton);

            //Delete button
            const deleteButton = document.createElement('button');
            deleteButton.classList.add("DeleteNoteButton");
            deleteButton.textContent = "Delete";
            //styling
            deleteButton.style.width = "54px";
            deleteButton.style.height = "22px";
            buttonNoteContainer.appendChild(deleteButton);

            //Eventlisteners for edit and delete buttons
            editButton.addEventListener('click', function () {
                editNote(note, index, notesList);
            });
            deleteButton.addEventListener('click', function () {
                deleteNote(index, notesList);
            });

            //Display the note
            const noteText = document.createElement('p');
            noteText.textContent = note;
            //styling
            noteText.style.marginLeft = "10px";
            noteText.style.marginBottom = "15px";
            noteText.style.marginTop = "1px";
            noteText.style.wordBreak = "break-all";
            noteText.style.whiteSpace = "normal";
            noteText.style.maxWidth = "300px";
            singleNoteContainer.appendChild(noteText);
        });
    }

    //If no notes stored, display the message
    if(notesListContainer.innerHTML === "") {
        const noteP = document.createElement('p');
        noteP.textContent = 'No notes found in localStorage';
        notesListContainer.appendChild(noteP);
    }
}

//Function to edit a note
function editNote(note, index, notesList) {
    //Connect to notes container
    const notesListContainer = document.getElementById('notesList');

    //Create a form container for editing the note
    const formContainer = document.createElement('div');
    formContainer.classList.add('editNoteFormContainer');

    //Creates input box for user input for note
    const noteInput = document.createElement('input');
    noteInput.type = "text";
    noteInput.value = note;  //displays current note before editing
    formContainer.appendChild(noteInput);

    //Save button for form input
    const saveButton = document.createElement('button');
    saveButton.textContent = "Save Changes";
    formContainer.appendChild(saveButton);

    notesListContainer.appendChild(formContainer);

    //Eventlistener to save the updated note
    saveButton.addEventListener('click', function () {
        notesList[index] = noteInput.value; //Update the note in the array
        localStorage.setItem('notes', JSON.stringify(notesList)); //Save the updated notes list to local storage
        notesListContainer.removeChild(formContainer); //Remove the form
        displayAllNotes(); //Redisplay the displayed notes
    });
}

//Function for deleting a note
function deleteNote(index, notesList) {
    notesList.splice(index, 1); //Remove the note from the array
    localStorage.setItem('notes', JSON.stringify(notesList)); //Save the updated notes list to local storage
    displayAllNotes(); //Redisplay the displayed notes
}

//Display all events and notes
function displayAll() {
    displayAllEvents();
    displayAllNotes();
}

// Call the function displayAll when the page is loaded so events and notes are all displayed
window.onload = displayAll;
