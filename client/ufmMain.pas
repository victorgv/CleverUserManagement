unit ufmMain;

interface

uses
  System.SysUtils, System.Types, System.UITypes, System.Classes, System.Variants,
  FMX.Types, FMX.Controls, FMX.Forms, FMX.Graphics, FMX.Dialogs, FMX.Objects,
  FMX.StdCtrls, FMX.Controls.Presentation, FMX.MultiView;

type
  TfmMain = class(TForm)
    MultiView1: TMultiView;
    bt_open_multiview: TButton;
    ToolBar1: TToolBar;
    TE_TITLE: TText;
  private
    { Private declarations }
  public
    { Public declarations }
  end;

var
  fmMain: TfmMain;

implementation

{$R *.fmx}

end.
