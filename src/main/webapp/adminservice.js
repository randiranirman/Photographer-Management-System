

export const createPhotographer = async (event) => {

    const username = document.getElementById("username").value;
    const password = document.getElementById("password").value;
    const role = "photographer"; // Role is fixed for photographer creation

    const formData = new URLSearchParams();
    formData.append("username", username);
    formData.append("password", password);
    formData.append("role", role);

    try {
        const response = await fetch("http://localhost:8080/CRUDApplication_war_exploded/photographer", {
            method: "POST",
            headers: {
                "Content-Type": "application/x-www-form-urlencoded"
            },
            body: formData.toString()
        });

        const result = await response.text();
        console.log("Server response:", result);

        if (response.ok) {
            alert("Photographer created successfully!");
        } else {
            alert("Failed to create photographer.");
        }
    } catch (error) {
        console.error("Error:", error);
        alert("Something went wrong while creating photographer.");
    }
};


export const deletePhotographer = async () => {
    const username = document.getElementById("deleteUsername").value;

    if (!username) {
        alert("Please enter a username to delete");
        return;
    }

    try {
        const formData = new URLSearchParams();
        formData.append("username", username); // Append username to the form data

        const response = await fetch(`http://localhost:8080/CRUDApplication_war_exploded/photographer`, {
            method: "DELETE",
            headers: {
                "Content-Type": "application/x-www-form-urlencoded"
            },
            body: formData.toString() // Send the URL-encoded body
        });

        if (response.ok) {
            alert("Photographer deleted successfully");
            document.getElementById("deleteUsername").value = ""; // Clear the input field
        } else {
            const errorText = await response.text();
            alert(`Error: ${errorText}`);
        }
    } catch (error) {
        alert("Error deleting photographer: " + error.message);
    }
};
