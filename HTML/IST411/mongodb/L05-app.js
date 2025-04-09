//Import Mongoose
const mongoose = require("mongoose")
//Connect DB
mongoose.connect("mongodb://127.0.0.1:27017/Bookstore")
.then(() => console.log("Successful"))
.catch((err) => {
    console.error(err);
});
//Define Schema
const bookSchema = new mongoose.Schema({
    name: String,
    age: Number
});
//Create model
//3rd parameter specifices name, unless it defaults to books
const Book = mongoose.model("Book",bookSchema, "Books");

//read
Book.find()
.then((books) => console.log(books))
.catch((err) => console.err(error));

