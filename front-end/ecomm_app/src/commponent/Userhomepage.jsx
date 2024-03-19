import { Route, Routes } from "react-router-dom";
import Updateuser from "./Updateuser";
import Usernav from "./Usernav";

const Userhomepage = () => {
    return (  
        <div className="">
            <Usernav/>
           <Routes>
             <Route path="updateuser" element={<Updateuser/>} ></Route>
           </Routes>
        </div>
    );
}
 
export default Userhomepage;