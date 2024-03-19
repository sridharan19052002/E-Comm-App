import style from "../styles/merchantsignup.module.css"
import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios"

const Updatemerchant = () => {
    let [name, setname] = useState("")
    let [gst_number, setgst_number] = useState("")
    let [email, setemail] = useState("")
    let [password, setpassword] = useState("")
    let [phone, setphone] = useState(0)
    let[id,setid]=useState(0)
    let navigate=useNavigate()
    
    let data = { id,name, gst_number, email, password, phone }
    let merchant=JSON.parse(localStorage.getItem("merchant"))
  console.log(merchant);
    useEffect(()=>
    {
        setid(merchant.data.id)
        setname(merchant.data.name)
        setgst_number(merchant.data.gst_number)
        setemail(merchant.data.email)
        setpassword(merchant.data.password)
        setphone(merchant.data.phone)
    },[])

    let updatedata = (e) => {
        e.preventDefault();
        axios.put(`http://localhost:8080/merchant`, data)
            .then((res) => {
                alert("Merchant Updated successfully")
                navigate("/merchanthome")
            })
            .catch((err) => {
                alert("Unable To Save Data")
            })

    }



    return (      
        <div id={style.merchantsignup}>
            <form onSubmit={updatedata} action="">

                <h2>Merchant update</h2><br />
                <hr /><br />
  
                <label htmlFor="">Id</label>
                <input value={id} onChange={(e) => { setid(e.target.value) }} placeholder="Enter The id" required type="number" />              

                <label htmlFor="">Name</label>
                <input value={name} onChange={(e) => { setname(e.target.value) }} placeholder="Enter The Name" required type="text" />

                <label htmlFor="">Gst_number</label>
                <input value={gst_number} onChange={(e) => { setgst_number(e.target.value) }} placeholder="Enter The Gst Number" required type="text" />

                <label htmlFor="">Email</label>
                <input value={email} onChange={(e) => { setemail(e.target.value) }} type="email" placeholder="Enter The Email" required />

                <label htmlFor="">Phone No</label>
                <input value={phone} onChange={(e) => { setphone(e.target.value) }} type="tel" pattern="[0-9]{10}" placeholder="Enter The  Phone" required />

                <label htmlFor="">password</label>
                <input value={password} onChange={(e) => { setpassword(e.target.value) }} type="text" placeholder="Enter The password" required />

                <button className="btn btn-outline-info ">Submit</button>

            </form>
        </div>
    );
} 
export default Updatemerchant;