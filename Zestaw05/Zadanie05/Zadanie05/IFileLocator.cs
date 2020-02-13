using System.IO;

namespace Zadanie05
{
    public interface IFileLocator
    {
        FileInfo GetFileInfo(string name);
    }
}