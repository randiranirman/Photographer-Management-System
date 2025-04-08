<h2 class="text-xl font-semibold">Rate a Photographer</h2>
<form id="ratingForm" class="space-y-2">
    <input type="text" id="ratePhotographerName" placeholder="Photographer Name"
           class="border p-2 rounded w-full">
    <select id="ratingValue" class="border p-2 rounded w-full">
        <option value="5">⭐⭐⭐⭐⭐ 5</option>
        <option value="4">⭐⭐⭐⭐ 4</option>
        <option value="3">⭐⭐⭐ 3</option>
        <option value="2">⭐⭐ 2</option>
        <option value="1">⭐ 1</option>
    </select>
    <button type="submit" class="bg-green-500 text-white px-4 py-2 rounded">Submit Rating</button>
</form>

<script type="module">
    document.getElementById("ratingForm").addEventListener("submit", async function (e) {
        e.preventDefault();

        const name = document.getElementById("ratePhotographerName").value;
        const rating = document.getElementById("ratingValue").value;

        const formData = new URLSearchParams();
        formData.append("photographerName", name);
        formData.append("rating", rating);

        const res = await fetch("http://localhost:8080/CRUDApplication_war_exploded/rate", {
            method: "POST",
            headers: {
                "Content-Type": "application/x-www-form-urlencoded"
            },
            body: formData.toString()
        });

        const json = await res.json();
        alert(json.message);
    });
</script>
