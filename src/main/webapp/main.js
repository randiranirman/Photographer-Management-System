export const signup = async () => {
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;
    const role = document.getElementById('role').value;

    const formData = new URLSearchParams();
    formData.append('action', 'signup');
    formData.append('username', username);
    formData.append('password', password);
    formData.append('role', role);

    try {
        const response = await fetch('http://localhost:8080/CRUDApplication_war_exploded/user', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded',
            },
            body: formData
        });

        const data = await response.json();
        console.log(data);
        alert(data.status || data.error);
    } catch (error) {
        console.error('Error:', error);
        alert('Signup failed: ' + error.message);
    }
    if( role === "admin"){
        window.location.href= "./admin.jsp";
        console.log("user directed successfylly ");
    }
};
