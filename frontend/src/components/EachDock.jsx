


const EachDock = ({data}) =>{
    return(
        <div className="p-2 m-3 ">
            <div>{data.name}</div>
            <div>{data.location}</div>
            <div>{data.description}</div>
            <div>{data.numberBikeAvailable}</div>
        </div>
    )
}
export default EachDock