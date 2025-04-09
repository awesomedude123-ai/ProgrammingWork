//Import Express
const express = require("express");

//Create a Route
const router = express.Router();

//Function to Get Data
async function getData(id){
    try{
        let response = await fetch(`https://jsonplaceholder.typicode.com/posts/${id}`);
        let data = await response.json();
        return data;
    }catch(e){
        console.error("Error:", e);
        throw new Error("Server Error");
    }
}

//Get ID Route
router.get("/posts/:id",async (req,res) => {
    if(req.params.id){
        var id = req.params.id;
        try{
            let data = await getData(id);
            res.json(data);
        }catch(err){
            console.error(err);
            res.status(500).send("Server Error");
        }
    }else{
        res.send("Need to provide a ID... /posts/#");
    }
});


//Post Route
router.post("/posts", (req,res) => {
    fetch(`https://jsonplaceholder.typicode.com/posts`,{
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(req.body),
    })
    .then(async(response) => {
        res.send(await response.json());
    })
    .catch((err) => {
        console.error(err);
        res.status(500).send("Server Error");
    });
});


//export router
module.exports = router;