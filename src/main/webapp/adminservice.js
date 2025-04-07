export const createPhotgrapher = async ( ) => {
    const  username = document.getElementById("username").value;
    const password = document.getElementById("password").value;


    const role ="photographer";

    const formData = new URLSearchParams();
    formData.append("action","createPhotographer");
    formData.append("username",username);
    formData.append("role",role);



}