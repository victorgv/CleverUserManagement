program CleverUserManagement;

uses
  System.StartUpCopy,
  FMX.Forms,
  ufmMain in 'ufmMain.pas' {fmMain},
  uTClientSession in 'communication\uTClientSession.pas',
  uTCommunicationManager in 'uTCommunicationManager.pas',
  udmCore in 'udmCore.pas' {dmCore: TDataModule};

{$R *.res}

begin
  Application.Initialize;
  Application.CreateForm(TfmMain, fmMain);
  Application.CreateForm(TdmCore, dmCore);
  Application.Run;
end.
