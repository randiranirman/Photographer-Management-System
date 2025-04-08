<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.example.crudapplication.User" %>
<%@ page import="org.example.crudapplication.sevlets.PhotographerFileHandler" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>View Photographers</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css" rel="stylesheet">
    <script type="module">
        // Function to handle photographer deletion

        import {deletePhotographer} from "./adminservice.js";
        // Make the function globally available
        window.deletePhotographer = deletePhotographer;
    </script>
</head>
<body class="bg-gradient-to-br from-blue-100 to-purple-100 min-h-screen flex flex-col items-center p-8 font-sans">
<div class="bg-white rounded-3xl shadow-2xl p-8 w-full max-w-4xl mb-8">
    <div class="flex justify-between items-center mb-6">
        <h1 class="text-3xl font-bold text-gray-800">
            <i class="fas fa-users text-purple-600 mr-2"></i>Photographers List
        </h1>
        <a href="admin.jsp" class="bg-blue-600 text-white px-4 py-2 rounded-lg font-medium hover:bg-blue-700 transition">
            <i class="fas fa-arrow-left mr-2"></i>Back to Admin
        </a>
    </div>

    <div class="overflow-x-auto">
        <table class="min-w-full bg-white rounded-lg overflow-hidden">
            <thead class="bg-gray-100">
            <tr>
                <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Username</th>
                <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Role</th>
                <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Actions</th>
            </tr>
            </thead>
            <tbody class="divide-y divide-gray-200">
            <%
                PhotographerFileHandler handler = new PhotographerFileHandler();
                ArrayList<User> photographers = handler.getAllPhotographers();
                for(User photographer : photographers) {
            %>
            <tr class="hover:bg-gray-50">
                <td class="px-6 py-4 whitespace-nowrap text-gray-700"><%= photographer.getUsername() %></td>
                <td class="px-6 py-4 whitespace-nowrap text-gray-700"><%= photographer.getRole() %></td>
                <td class="px-6 py-4 whitespace-nowrap">
                    <button onclick="deletePhotographer('<%= photographer.getUsername() %>')"
                            class="text-red-600 hover:text-red-900 font-medium">
                        <i class="fas fa-trash-alt mr-1"></i>Delete
                    </button>
                </td>
            </tr>
            <% } %>

            <% if(photographers.isEmpty()) { %>
            <tr>
                <td colspan="3" class="px-6 py-4 text-center text-gray-500">No photographers found</td>
            </tr>
            <% } %>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>