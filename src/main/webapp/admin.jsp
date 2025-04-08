<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Admin Dashboard</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <script type="module" >
        import {createPhotographer} from "./adminservice.js";
        import {deletePhotographer} from "./adminservice.js";
        window.deletePhotographer = deletePhotographer;

        window.createPhotographer = createPhotographer;




    </script>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css" rel="stylesheet">
</head>
<body class="bg-gradient-to-br from-blue-100 to-purple-100 min-h-screen flex items-center justify-center font-sans">

<div class="bg-white rounded-3xl shadow-2xl p-8 w-full max-w-2xl">
    <h1 class="text-4xl font-extrabold text-gray-800 mb-8 text-center">
        <i class="fas fa-user-shield text-blue-600 mr-2"></i>Admin Dashboard
    </h1>

    <div class="space-y-8">
        <!-- Create Photographer -->
        <div class="bg-white border border-gray-200 p-6 rounded-2xl shadow-sm hover:shadow-md transition duration-200">
            <h2 class="text-2xl font-semibold text-gray-700 mb-4 flex items-center">
                <i class="fas fa-user-plus text-green-500 mr-2"></i>Create Photographer
            </h2>
            <form>
                <div class="mb-4">
                    <input id="username" type="text" placeholder="Username"
                           class="w-full px-4 py-2 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-400">
                </div>
                <div class="mb-4">
                    <input type="password"  id="password" placeholder="Password"
                           class="w-full px-4 py-2 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-400">
                </div>
                <button onclick="createPhotographer() ;return false;" type="submit"
                        class="bg-blue-600 text-white w-full py-2 rounded-lg font-medium hover:bg-blue-700 transition">
                    <i class="fas fa-plus-circle mr-2"></i>Create
                </button>
            </form>
        </div>

        <!-- Delete Photographer -->
        <div class="bg-white border border-gray-200 p-6 rounded-2xl shadow-sm hover:shadow-md transition duration-200">
            <h2 class="text-2xl font-semibold text-gray-700 mb-4 flex items-center">
                <i class="fas fa-user-times text-red-500 mr-2"></i>Delete Photographer
            </h2>
            <form>
                <div class="mb-4">
                    <input id="deleteUsername" type="text" placeholder="Photographer Username"
                           class="w-full px-4 py-2 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-red-400">
                </div>
                <button type="submit"
                        onclick ="deletePhotographer() ;return false ;"
                        class="bg-red-600 text-white w-full py-2 rounded-lg font-medium hover:bg-red-700 transition">
                    <i class="fas fa-trash-alt mr-2"></i>Delete
                </button>
            </form>
        </div>
    </div>
</div>

</body>
</html>
