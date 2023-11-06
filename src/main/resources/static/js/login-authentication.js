import * as database from "https://www.gstatic.com/firebasejs/10.5.2/firebase-database.js";

// Function to find the customer with matching username and password
const findMatchingCustomer = (snapshot, username, password) => {
    for (const snap in snapshot.val()) {
        const customerData = snapshot.val()[snap];
        if (customerData.username === username && customerData.password === password) {
            console.log("Authentication successful!");
            // You can add code to redirect the user to a protected page here.
            return;
        }
    }
    console.log("Invalid username or password");
};

window.checkCredentials = function() {
    console.log("checkCredentials function called");
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;

    const dbRef = database.getDatabase();
    const customersRef = database.ref(dbRef, "Customer");

    database.get(customersRef)
        .then((snapshot) => {
            if (snapshot.exists()) {
                findMatchingCustomer(snapshot, username, password);
            } else {
                console.log("No data available in the 'Customer' node");
            }
        })
        .catch((error) => {
            console.error("Error code:", error.code);
            console.error("Error message:", error.message);
        });
};