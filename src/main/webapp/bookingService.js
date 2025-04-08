export const createBooking = async () => {
    const customerNameInput = document.getElementById("customerName");
    const photographerNameInput = document.getElementById("photographerName");

    const customerName = customerNameInput.value;
    const photographerName = photographerNameInput.value;

    const formData = new URLSearchParams();
    formData.append("customerName", customerName);
    formData.append("photographerName", photographerName);

    try {
        const response = await fetch("http://localhost:8080/CRUDApplication_war_exploded/book", {
            method: "POST",
            headers: {
                "Content-Type": "application/x-www-form-urlencoded"
            },
            body: formData.toString()
        });

        if (!response.ok) {
            throw new Error(`HTTP error! Status: ${response.status}`);
        }

        const result = await response.text();
        console.log("Booking created successfully:", result);
        alert("Booking created successfully!");

    } catch (error) {
        console.error("Error creating booking:", error);
        alert("Failed to create booking.");
    }
};
