namespace Zadanie05
{
    public interface ICacheStore
    {
        bool AddOrUpdate(string id, string message);
        
        string GetOrAdd(string id, string message);
    }
}