import axios from "axios";
import { useState } from "react";
import { useNavigate } from "react-router-dom";
const Addproduct = () => {
    let navi=useNavigate()
    let [name,setName]=useState("")
    let [brand,setBrand]=useState("")
    let [category,setCategory]=useState("")
    let [cost,setCost]=useState("")
    let [image_Url,setImage_Url]=useState("")
    let [description,setDescription]=useState("")
    let data={name,brand,category,cost,image_Url,description}
    let merchant=JSON.parse(localStorage.getItem("merchant"))
    let k=merchant.data.id
    function action1(e){
        e.preventDefault()
        axios.post(`http://localhost:8080/products/${k}`,data)
        .then((res)=>{
            localStorage.setItem("product",JSON.stringify(res.data.data))
            alert("product added")
            navi("/merchanthome/productview")

        })
        .catch((err)=>{
            alert("product not added")
        })
    }
    return (  
        <div className="addProduct">
        <h1>Add Product</h1>
        <form onSubmit={action1}>
            <input type="text" placeholder="name" value={name} onChange={(i)=>{setName(i.target.value)}}/>
            <input type="text" placeholder="brand" value={brand} onChange={(i)=>{setBrand(i.target.value)}}/>
            <input type="text" placeholder="category" value={category} onChange={(i)=>{setCategory(i.target.value)}}/>
            <input type="number" placeholder="cost" value={cost} onChange={(i)=>{setCost(i.target.value)}}/>
            <input type="text" placeholder="image_url" value={image_Url} onChange={(i)=>{setImage_Url(i.target.value)}}/>
            <input type="text" placeholder="description" value={description} onChange={(i)=>{setDescription(i.target.value)}}/>
            <button>add</button>
        </form>

    </div>
    );
}
 
export default Addproduct;