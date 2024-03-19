import { Navigate } from "react-router-dom";
const ProtectRouting = ({Child}) => {
    let x=localStorage.getItem("merchant")
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
              {verifyprotect() ? <Child/> :<Navigate to="/merchantlogin" />}
            </div>
     );
}
 
export default ProtectRouting;