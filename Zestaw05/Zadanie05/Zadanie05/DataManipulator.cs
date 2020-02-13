using System.IO;

namespace Zadanie05
{
    public class DataManipulator
    {
        private MessageStorage messageStorage;

        public DataManipulator(DirectoryInfo workingDirectory)
        {
            this.messageStorage = new MessageStorage(new SqlStorage(), new Cache(), new Logger() );
        }

        public virtual string Read(string path)
        {
            string message;
            messageStorage.Logger.LogMessage($"Readline message {path}.", 1);
            
            message = messageStorage.Cache.GetOrAdd(path, messageStorage.Store.Read(path));
            
            messageStorage.Logger.LogMessage($"Returning message {path}.", 1);
            return message;
        }

        public virtual void Save(string path, string message)
        {
            messageStorage.Logger.LogMessage($"Saving message {path}.", 0);
            messageStorage.Store.Save(path, message);
            
            messageStorage.Cache.AddOrUpdate(path, message);

            messageStorage.Logger.LogMessage($"Saving message {path}.", 0);
        }

    }
}