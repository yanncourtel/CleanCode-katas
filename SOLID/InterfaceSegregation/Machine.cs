namespace SOLID.InterfaceSegregation
{
    public interface IMachine : IPrint, IScan {
        
        void Fax();
        
        void Photocopy();
    }
}
