import axios from "axios";
import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";


const Updateuser = () => {
    let navigate=useNavigate() 
    let [id, setid] = useState("")
    let [name, setname] = useState("")
    let [phone, setphone] = useState("")
    let [email, setemail] = useState("")
    let [password, setpassword] = useState("")
    let [age, setage] = useState("")
    let [gender, setgender] = useState("")
    let data = { id, name, phone, password, email, gender ,age}
    let u = JSON.parse(localStorage.getItem("user"))
    useEffect(() => {
        setid(u.id)
        setname(u.name)
        setphone(u.phone)
        setemail(u.email)
        setpassword(u.password)
        setgender(u.gender)
        setage(u.age)
    }, [])
    let updateuser = (e) => {
        e.preventDefault()
        axios.put(`http://localhost:8080/user`, data)
            .then((res) => {
                alert("user updated successfully")
                navigate("/userhomepage")                
                
            })
            .catch((res) => {
                alert("unable to update user")
            })
    }
    return (

        <div >
            <form onSubmit={updateuser} action="">
                <h2>Update User</h2><br />
                <hr /><br />

                <label htmlFor="">Id</label>
                <input value={id} onChange={(e) => { setid(e.target.value) }} placeholder="Enter The Name" required type="text" />

                <label htmlFor="">Name</label>
                <input value={name} onChange={(e) => { setname(e.target.value) }} placeholder="Enter The Name" required type="text" />

                <label htmlFor="">Email</label>
                <input value={email} onChange={(e) => { setemail(e.target.value) }} type="email" placeholder="Enter The Email" required />

                <label htmlFor="">Phone No</label>
                <input value={phone} onChange={(e) => { setphone(e.target.value) }} type="tel" pattern="[0-9]{10}" placeholder="Enter The  Phone" required />

                <label htmlFor="">password</label>
                <input value={password} onChange={(e) => { setpassword(e.target.value) }} type="password" placeholder="Enter The password" required />

                <label htmlFor="">Age</label>
                <input value={age} onChange={(e) => { setage(e.target.value) }} placeholder="Enter The Age" required type="number" />

                <label htmlFor="">Gender</label>
                <input type="text" value={gender} onChange={(e) => { setgender(e.target.value) }} placeholder="Enter The Gender" required />
                <button className="btn btn-outline-info ">Submit</button>

            </form>
        </div>

    );
}

export default Updateuser;