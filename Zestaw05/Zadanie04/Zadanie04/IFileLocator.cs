using System.IO;

namespace Zadanie04
{
    public interface IFileLocator
    {
        FileInfo GetFileInfo(string name);
    }
}