export function testDeepMatching(){
    let oraganization = { 
        name: "Microsoft Corp.", 
        address: 
        { street: "J. M. Road", 
                    city: "Pune", state: "Maharashtra", 
                    pincode: "411002"
        } }; 
        let {address: {pincode}} = oraganization; //Deep matching 
        console.log("Pin Code : ",pincode); 
}