export function testArrow(){
    let names=['Tom', 'Ivan', 'Jerry'];
    let arro=[];
    names.forEach(
        n=>{
            let obj={name:n,name_length:n.length};
            console.log(obj);
            arro.push(obj);
        }
    )
    console.log(arro);
}