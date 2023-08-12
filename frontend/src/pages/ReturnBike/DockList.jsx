import DockItem from "./DockItem"
const DockList = () => {
    const dock_list = [
        {
            id: 1,
            "location":"HoangMai",
            "description":"first dock",
            "name":"HoangMai Dock"
        },
        {
            id: 2,
            "location":"HoangMai",
            "description":"first dock",
            "name":"HoangMai Dock"
        }
    ]
    return(
        <div className="bg-red-500 w-2/3 p-2">
            <h1 className="text-xl font-bold">Select a dock to return your bike</h1>
            <div className="">
                {dock_list.map((dock) => (
                    <DockItem key={dock.id} item={dock}/>
                ))}
            </div>

        </div>
    )
}

export default DockList;