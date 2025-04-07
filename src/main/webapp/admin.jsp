<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Admin Dashboard</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 font-sans min-h-screen flex items-center justify-center">
<div class="bg-white rounded-2xl shadow-xl p-8 w-full max-w-xl">
    <h1 class="text-3xl font-bold text-gray-800 mb-6 text-center">Admin Dashboard</h1>

    <div class="space-y-6">
        <!-- Create Photographer Section -->
        <div class="bg-gray-50 p-4 rounded-xl shadow-md">
            <h2 class="text-xl font-semibold mb-2 text-gray-700">Create Photographer</h2>
            <form>
                <input type="text" placeholder="Username" class="w-full mb-2 px-4 py-2 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-400">
                <input type="password" placeholder="Password" class="w-full mb-2 px-4 py-2 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-400">
                <button class="bg-blue-600 text-white px-4 py-2 rounded-lg hover:bg-blue-700 transition w-full">Create</button>
            </form>
        </div>

        <!-- Delete Photographer Section -->
        <div class="bg-gray-50 p-4 rounded-xl shadow-md">
            <h2 class="text-xl font-semibold mb-2 text-gray-700">Delete Photographer</h2>
            <form>
                <input type="text" placeholder="Photographer Username" class="w-full mb-2 px-4 py-2 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-red-400">
                <button class="bg-red-600 text-white px-4 py-2 rounded-lg hover:bg-red-700 transition w-full">Delete</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
