using System;
using System.IO;

namespace FileStoreApp
{
    public class FileStore : IFileStore
    {
        private readonly IFileWriter fileWriter;
        private readonly IFileReader fileReader;
        private const string FileExtension = ".txt";

        public string WorkingDirectory { get; set; }

        public FileStore(string workingDirectory, IFileWriter fileWriter, IFileReader fileReader)
        {
            this.fileWriter = fileWriter ?? throw new ArgumentNullException(nameof(fileWriter));
            this.fileReader = fileReader ?? throw new ArgumentNullException(nameof(fileReader));
            WorkingDirectory = workingDirectory ?? throw new ArgumentNullException(nameof(workingDirectory));
        }

        public void Save(string fileName, string message)
        {
            ValidateEmptyField(fileName);
            ValidateEmptyField(message);

            //Cette methode va evoluer pour inclure d'autres RGs pour la gestion des noms de fichiers.
            //....

            var filePath = GenerateFileFullPath(fileName);

            fileWriter.WriteText(message, filePath);
        }

        public string Read(string fileName)
        {
            ValidateEmptyField(fileName);

            //Cette methode va evoluer pour inclure d'autres RGs pour la gestion des noms de fichiers.
            //....

            return fileReader.Read(fileName);
        }

        private string GenerateFileFullPath(string fileName)
        {
            return Path.Combine(WorkingDirectory, fileName + FileExtension);
        }

        private static void ValidateEmptyField(string fieldValue)
        {
            if (string.IsNullOrWhiteSpace(fieldValue))
            {
                throw new ArgumentNullException(nameof(fieldValue));
            }
        }
    }
}