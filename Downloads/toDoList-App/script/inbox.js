function newElement(){
  var li=document.createElement("li");
  var inputValue=document.getElementById("myInput").value;
  var t=document.createTextNode(inputValue);
  li.appendChild(t);

  if (inputValue===''){
      alert("You must write something!");
  }else{
    document.getElementById("dropdownContainer").appendChild(li);
    var container=document.getElementById("dropdownContainer");
    var newDropdown=document.createElement("select");
    newDropdown.classList.add("dropdown");
    var options = [
        { value:"Hard", text:"Hard" },
        { value:"Medium", text:"Medium" },
        { value:"Easy", text:"Easy" },
    ];
     options.forEach(function(option) {
        var newOption=document.createElement("option");
        newOption.value=option.value;
        newOption.textContent=option.text;
        newDropdown.appendChild(newOption);
    });
    container.appendChild(newDropdown);
     container.appendChild(document.createElement("br"));
    container.appendChild(document.createElement("br"));
   }
    document.getElementById("myInput").value="";

}
  
  

  
