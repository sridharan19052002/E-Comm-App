import { useState } from "react";
import style from "../styles/usersignup.module.css"
import axios from "axios"
import { useNavigate } from "react-router-dom";
const Usersignup = () => {

     let[name,setname]=useState("")
     let[email,setemail]=useState("")
     let[password,setpassword]=useState("")
     let[phone,setphone]=useState(0)
     let[age,setage]=useState("")
     let[gender,setgender]=useState("")
     let navigate=useNavigate()

     let data={name,email,password,phone,age,gender}

     let adduser = (e) => {
        e.preventDefault();
        axios.post(`http://localhost:8080/user`, data)
            .then((res) => {
                alert("User Added successfully")
                navigate("/userlogin")
            })
            .catch((err) => {
                alert("Unable To Save Data")
            })

    }
     
 
    return (
        <div id={style.usersignup}>
            <form onSubmit={adduser} action="">
                    <h2>User SignUp</h2><br />
                    <hr /><br />
                <label htmlFor="">Name</label>
                <input value={name} onChange={(e)=>{setname(e.target.value)}} placeholder="Enter The Name" required type="text" />

                <label htmlFor="">Email</label>
                <input value={email} onChange={(e)=>{setemail(e.target.value)}} type="email" placeholder="Enter The Email" required />

                <label htmlFor="">Phone No</label>
                <input value={phone} onChange={(e)=>{setphone(e.target.value)}} type="tel" pattern="[0-9]{10}" placeholder="Enter The  Phone" required />

                <label htmlFor="">password</label>
                <input value={password} onChange={(e)=>{setpassword(e.target.value)}} type="password" placeholder="Enter The password" required />

                <label htmlFor="">Age</label>
                <input value={age} onChange={(e)=>{setage(e.target.value)}} placeholder="Enter The Age" required type="number" />

                <label htmlFor="">Gender</label>
                <input type="text" value={gender} onChange={(e)=>{setgender(e.target.value)}} placeholder="Enter The Gender" required />
                <button className="btn btn-outline-info ">Submit</button>

            </form>
        </div>
    );
}

export default Usersignup;