unit uTClientSession;

interface

type
  TClientSession = class(TObject) // Guarda información de la sesión del cliente y token de acceso al server
  private
    fToken: String;
    fUserName: String;
    fPassword: String;
    fUserID: integer; // ID único del usuario
    fNAME: String; // Nombre del usuario
    fROLE: String; // Role del usuario en la aplicación
  public
    property Token: String read fToken;
    property UserName: String read fUserName;
    property UserID: integer read fUserID;
    property NAME: String read fName;
    property ROLE: String read fROLE;

    constructor create(const p_token, p_userName, p_password: String);
  end;

implementation

{ TClientSession }

constructor TClientSession.create(const p_token, p_userName,  p_password: String);
begin
  inherited create;

end;

end.
