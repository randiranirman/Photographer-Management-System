export const createPhotographer = async () => {
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
