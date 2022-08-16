
let dragged;
let id;
let index;
let indexDrop;
let list;




// JS functions for draggable list elements

document.addEventListener("dragstart", ({target}) => {
      dragged = target;
      id = target.id;
      list = target.parentNode.children;
      for(let i = 1; i < list.length; i += 1) {
        if(list[i] === dragged){
          index = i;
        }
      }
});

document.addEventListener("dragover", (event) => {
      event.preventDefault();
});

document.addEventListener("drop", ({target}) => {
   if(target.className == "dropzone" && target.id !== id) {
       dragged.remove( dragged );
      for(let i = 0; i < list.length; i += 1) {
        if(list[i] === target){
          indexDrop = i;
        }
      }
      console.log(index, indexDrop);
      if(index > indexDrop) {
        target.before( dragged );
      } else {
       target.after( dragged );
      }
    }
});


function setTitle(){
  let titleInput = document.getElementById("listTitle").value;
  let listName = document.getElementById("listName");
  listName.innerHTML= titleInput;
}


  // JS Function to show list, after create list button has been clicked

function createList() {
    document.getElementById("listy").style.display = "";
    document.getElementById("savebt").style.display = "";
    document.getElementById("createButton").style.display = "none";
}

// function to decide which drop down menu will be shown for list creation
function selectOptionsToDisplay(){
  let elem = document.getElementsByClassName("bb");
  let cat = document.getElementById("Category");
  let categoryValue = cat.value;

  if(categoryValue == "NBA"){
    for(const element of elem){
    element.setAttribute("data-bs-target", "#nbaTeamsModal");  
    }
  }
  else if(categoryValue == "NFL"){
    for(const element of elem){
      element.setAttribute("data-bs-target", "#nflTeamsModal");  
      }
  }
  else if(categoryValue == "Raids"){
    for(const element of elem){
      element.setAttribute("data-bs-target", "#wowRaidsModal");  
      }
  }
  else if(categoryValue == "Champion"){
    for(const element of elem){
      element.setAttribute("data-bs-target", "#leagueChampionsModal");  
      }
  }
  else if(categoryValue == "Pokemon"){ 
    for(const element of elem){
      element.setAttribute("data-bs-target", "#legendaryPokeTeamsModal");  
      }
  }

}



// function to set the text of the list element, after an option has been chosen from the drop down menu
function setListText(){
  let sel = document.getElementById("nbaSelection");
  let texty = sel.options[sel.selectedIndex].text;
  let buttons = document.getElementsByTagName("button");
  let buttonsCount = buttons.length;
  let element = document.getElementById("listyButton")
  let eleVal = element.value;
  for(let i=0; i<=buttonsCount; i+=1){
    document.getElementById(eleVal).innerHTML=texty;
  }
}

// function to ensure that a user has entered information into the login modal before it closes
function validateLoginForm(){
  let x = document.forms["loginForm"]["username"].value;
  let y = document.forms["loginForm"]["password"].value;
  if(x == "" || x == null){
    alert("Please Enter a Username");
    return false;
  }

  if (y == "" || y == null){
    alert("please Enter a Password");
    return false;
  }
}

//function to hide the login/signup buttons and display the account image, after user has logged in or signed up
function loginButton(){
  document.getElementById("profileB").style.display = "";
  document.getElementById("loginB").style.display = "none";
  document.getElementById("signupB").style.display = "none";

}

// CRUD functions
// read by ID function

const readByEntryId = (entryId) => {
  fetch(`${taskUrl}/readById/${entryId}`)
  .then(response => response.json()).then(model => {
    console.log("Entry read By ID: ")
    console.log(model);
    return model;
  })
  .catch(err => console.error(`Error: ${err}`));
}

//create new list function

const createNewList = () => {
  let titleInput = document.getElementById("listTitle").value;
  let cList = document.querySelector("#listy").value;
  console.log(cList);

  const obj = {
    "listName": titleInput
  }

  fetch("http://localhost:8080/ListModel" , {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify(obj)
  })
  .then(res => res.json())
  .then(data => console.log(data))
  .catch(err => console.err(err))
}
// adding on click functionality for createNewList
const makeList = document.querySelector("#saveButton");
makeList.addEventListener("click", (event) => {
  event.preventDefault();
  createNewList();
  listEntryCreate();
});

//delete list function

const deleteList = (listId) => {
  fetch(`http://localhost:8080/delete/${listId}`, {
    method: "DELETE",
    headers: {
      "Content-Type": "application/json"
    }
  })
  .then(res => res.json())
  .then(data => console.log(data))
  .catch(err => console.err(err))
}

// update list function


//List Entries CRUD functions

//Create List Entries
const listEntryCreate = () => {
  let titleInput = document.getElementById("listTitle").value;
  let arr = [];
  Array.from(document.querySelectorAll('#listy>ol>li'),li => arr.push(li.textContent))
  console.log(arr);
  
  for(let i = 0; i <= arr.length-1; i++){
    const obj = {
      "list_entry": arr[i],
      "listModel": {"list_Id" : arr[i]} 
    }
    fetch("http://localhost:8080/ListEntries" , {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify(obj)
  })
  .then(res => res.json())
  .then(data => console.log(data))
  .catch(err => console.err(err))
}

// delete list entry by ID


const deleteEntry = (entryId) => {
  fetch(`http://localhost:8080/deleteEntry/${entryId}`, {
    method: "DELETE",
    headers: {
      "Content-Type": "application/json"
    }
  })
  .then(res => res.json())
  .then(data => console.log(data))
  .catch(err => console.err(err))
}
  

}

