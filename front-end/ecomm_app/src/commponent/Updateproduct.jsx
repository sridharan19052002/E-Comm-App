import { useEffect, useState } from "react"
import axios from "axios";
import { useNavigate } from "react-router-dom";

const Updateproduct = () => {
    let [id, setId] = useState()
    let [name, setName] = useState("")
    let [brand, setBrand] = useState("")
    let [category, setCategory] = useState("")
    let [cost, setCost] = useState("")
    let [image_Url, setImage_Url] = useState("")
    let [description, setDescription] = useState("")
    let data = { id,name, brand, category, cost, image_Url, description }
    let navi=useNavigate()
    function action1(e) {
        e.preventDefault()
        axios.put(`http://localhost:8080/products`, data)
            .then((res) => {
                alert("product updated")
                navi("/merchanthome/productview")
            })
            .catch((err) => {
                alert("product not updated")
            })
    }
    return (

        <div className="addProduct">
            <h1>Add Product</h1>
            <form onSubmit={action1}>
                <input type="number" placeholder="id" value={id} onChange={(i) => { setId(i.target.value) }} />
                <input type="text" placeholder="name" value={name} onChange={(i) => { setName(i.target.value) }} />
                <input type="text" placeholder="brand" value={brand} onChange={(i) => { setBrand(i.target.value) }} />
                <input type="text" placeholder="category" value={category} onChange={(i) => { setCategory(i.target.value) }} />
                <input type="number" placeholder="cost" value={cost} onChange={(i) => { setCost(i.target.value) }} />
                <input type="text" placeholder="image_url" value={image_Url} onChange={(i) => { setImage_Url(i.target.value) }} />
                <input type="text" placeholder="description" value={description} onChange={(i) => { setDescription(i.target.value) }} />
                <button>Edit</button>
            </form>

        </div>
    );



}

export default Updateproduct;