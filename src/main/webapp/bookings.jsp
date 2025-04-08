<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book an Appointment</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 min-h-screen flex items-center justify-center">

<div class="bg-white p-8 rounded-lg shadow-lg w-full max-w-md">
    <h2 class="text-2xl font-bold text-center text-gray-800 mb-6">Book a Photographer</h2>

    <form action="/book" method="post" class="space-y-4">
        <!-- Customer Name -->
        <div>
            <label for="customerName" class="block text-sm font-medium text-gray-700">Your Name</label>
            <input type="text" id="customerName" name="customerName" required
                   class="mt-1 block w-full px-4 py-2 border border-gray-300 rounded-lg shadow-sm focus:ring-blue-500 focus:border-blue-500">
        </div>

        <!-- Photographer Name -->
        <div>
            <label for="photographerName" class="block text-sm font-medium text-gray-700">Photographer Name</label>
            <input type="text" id="photographerName" name="photographerName" required
                   class="mt-1 block w-full px-4 py-2 border border-gray-300 rounded-lg shadow-sm focus:ring-blue-500 focus:border-blue-500">
        </div>

        <!-- Submit Button -->
        <div>
            <button type="submit"
                    class="w-full bg-blue-600 text-white font-semibold py-2 rounded-lg hover:bg-blue-700 transition duration-200">
                Book Appointment
            </button>
        </div>
    </form>
</div>

</body>
</html>
