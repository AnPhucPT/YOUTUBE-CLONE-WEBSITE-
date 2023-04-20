document.getElementById('reset_form_video').addEventListener("click", () => {
        document.getElementById('Href').value = ""
        document.getElementById('Title').value = ""
        document.getElementById('description').value = ""
        document.getElementById('submitButton').innerText = "Create"
    })