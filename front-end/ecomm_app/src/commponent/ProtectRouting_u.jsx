import { Navigate } from "react-router-dom";
const ProtectRouting_u = ({Child}) => {
    let x=localStorage.getItem("user")
    let verifyprotect=()=>
    {
        if(x==null)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    return ( 
            <div>
              {verifyprotect() ? <Child/> :<Navigate to="/userlogin" />}
            </div>
     );
}
 
export default ProtectRouting_u;