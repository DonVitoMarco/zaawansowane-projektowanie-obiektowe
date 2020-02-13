using System.IO;

namespace Zadanie03
{
    public interface IStore
    {
        bool Save(string id, string message);
        
        string Read(string id);
        
        FileInfo GetFileInfo(string name);
    }
}