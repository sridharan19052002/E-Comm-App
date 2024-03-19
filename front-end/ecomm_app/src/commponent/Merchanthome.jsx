import { Route, Routes } from "react-router-dom";
import Merchantnavbar from "./Merchantnavbar";
import Productview from "./Productview";
import Updatemerchant from "./Updatemerchant";
import Addproduct from "./Addproduct";
import Updateproduct from "./Updateproduct";

const Merchanthome = () => {
    return (
        <div>
            
            <Merchantnavbar/>
            <Routes>
                <Route path="/productview" element={<Productview/>} ></Route>
                <Route path="/updatemerchant" element={<Updatemerchant/>} ></Route>
                <Route path="/addproduct" element={<Addproduct/>} ></Route>
                <Route path="/updateproduct" element={<Updateproduct/>} ></Route>
            </Routes>
        </div>
    );
}

export default Merchanthome;