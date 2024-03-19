import { useState } from 'react';
import axios from "axios"
import Form from 'react-bootstrap/Form';
import { Link, useNavigate } from 'react-router-dom';
const Merchantlogin = () => {
    
    let[email,setemail]=useState("")
    let[password,setpassword]=useState("")
    let navigate=useNavigate()

    function verifymerchant(e)
    {
        e.preventDefault();
        axios.get(`http://localhost:8080/merchant/find_merchant_by_email_password?email=${email}&password=${password}`)
        .then((res)=>{
            alert("Login successfully.....")
            console.log(res.data.data);
            localStorage.setItem("merchant",JSON.stringify(res.data))
             navigate("/merchanthome")
         })
        .catch((res)=>{ console.log(res.data); alert("Invalid Credentials")})
    }


    return (  

        <div className="mercahntlogin">
            <Form>
                
            <Form.Group className="mb-3" controlId="formGroupEmail">
                <Form.Label>Email address</Form.Label>
                <Form.Control value={email} onChange={(e)=>{setemail(e.target.value)}} type="email" placeholder="Enter email" />
            </Form.Group>

            <Form.Group className="mb-3" controlId="formGroupPassword">
                <Form.Label>Password</Form.Label>
                <Form.Control value={password} onChange={(e)=>{setpassword(e.target.value)}} type="password" placeholder="Password" />
            </Form.Group>

            <Form.Group>
                 <button onClick={verifymerchant} className='btn btn-success mx-5'>Sign In</button>
                 <button className='btn btn-danger mx-5'><Link to="/merchantsignup"> Sign Up</Link></button>
            </Form.Group>
            
    </Form>
        </div>
    );
}
 
export default Merchantlogin;