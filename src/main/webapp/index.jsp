<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Photography Management System</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script> <!-- Add Axios -->
</head>
<body class="bg-gray-100 flex items-center justify-center min-h-screen">
<div class="bg-white p-8 rounded-lg shadow-md w-full max-w-md">
    <h2 class="text-2xl font-bold mb-6 text-center text-gray-800">Signup</h2>
    <form id="signupForm" class="space-y-4">
        <div>
            <input
                    type="text"
                    id="username"
                    placeholder="Username"
                    required
                    class="w-full px-4 py-2 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500"
            />
        </div>
        <div>
            <input
                    type="password"
                    id="password"
                    placeholder="Password"
                    required
                    class="w-full px-4 py-2 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500"
            />
        </div>
        <div>
            <select
                    id="role"
                    required
                    class="w-full px-4 py-2 border border-gray-300 rounded-lg bg-white focus:outline-none focus:ring-2 focus:ring-blue-500"
            >
                <option value="" disabled selected>Select Role</option>
                <option value="admin">Admin</option>
                <option value="customer">Customer</option>
                <option value="photographer">Photographer</option>
            </select>
        </div>
        <div>
            <button
                    type="submit"
                    class="w-full bg-blue-500 text-white font-semibold py-2 rounded-lg hover:bg-blue-600 transition duration-200"
            >
                Sign Up
            </button>
        </div>
    </form>
</div>

<script type="module">
    import { signup } from './main.js'; // Fixed file name
    document.getElementById('signupForm').addEventListener('submit', (e) => {
        e.preventDefault();
        signup();
    });
</script>
</body>
</html>