import { useState } from 'react';
import Form from 'react-bootstrap/Form';
import { Link } from 'react-router-dom';
import { useNavigate } from 'react-router-dom';
import axios from "axios"
const Userlogin = () => {

  let[email,setemail]=useState("")
  let[password,setpassword]=useState("")
  let navigate=useNavigate()

  function verifyuser(e)
  {
      e.preventDefault();
      axios.get(`http://localhost:8080/user/find_user_by_email_password?email=${email}&password=${password}`)
      .then((res)=>{
           localStorage.setItem("user",JSON.stringify(res.data.data))
           alert("login successfully....")
           navigate("/userhomepage")
       })
      .catch((res)=>{ console.log(res); alert("Invalid Credentials")})
  }


    return ( 
        <div>
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
                 <button  onClick={verifyuser}  className='btn btn-success mx-5'>Sign In</button>
                 <button className='btn btn-danger mx-5'><Link to="/usersignup">Sign Up</Link></button>
            </Form.Group>
            
          </Form>
        </div>
     );
}
 
export default Userlogin;