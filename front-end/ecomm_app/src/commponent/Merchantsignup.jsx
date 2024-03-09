import { useState } from "react";
import style from "../styles/merchantsignup.module.css"
import axios from "axios"
import { useNavigate } from "react-router-dom";
const Merchantsignup = () => {

    let [name, setname] = useState("")
    let [gst_number, setgst_number] = useState("")
    let [email, setemail] = useState("")
    let [password, setpassword] = useState("")
    let [phone, setphone] = useState(0)
    let navigate=useNavigate()

    let data = { name, gst_number, email, password, phone }
    let addmerchant = (e) => {
        e.preventDefault();
        axios.post(`http://localhost:8080/merchant`, data)
            .then((res) => {
                alert("Merchant Added successfully")
                navigate("/merchantlogin")
            })
            .catch((err) => {
                alert("Unable To Save Data")
            })

    }


    return (
        <div id={style.merchantsignup}>
            <form onSubmit={addmerchant} action="">

                <h2>Merchant SignUp</h2><br />
                <hr /><br />

                <label htmlFor="">Name</label>
                <input value={name} onChange={(e) => { setname(e.target.value) }} placeholder="Enter The Name" required type="text" />

                <label htmlFor="">Gst_number</label>
                <input value={gst_number} onChange={(e) => { setgst_number(e.target.value) }} placeholder="Enter The Gst Number" required type="text" />

                <label htmlFor="">Email</label>
                <input value={email} onChange={(e) => { setemail(e.target.value) }} type="email" placeholder="Enter The Email" required />

                <label htmlFor="">Phone No</label>
                <input value={phone} onChange={(e) => { setphone(e.target.value) }} type="tel" pattern="[0-9]{10}" placeholder="Enter The  Phone" required />

                <label htmlFor="">password</label>
                <input value={password} onChange={(e) => { setpassword(e.target.value) }} type="password" placeholder="Enter The password" required />

                <button className="btn btn-outline-info ">Submit</button>

            </form>
        </div>
    );
}

export default Merchantsignup;