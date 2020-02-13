namespace Zadanie05
{
    public interface IStore
    {
        bool Save(string id, string message);
        
        string Read(string id);
    }
}