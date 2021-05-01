package pageObjects;

import static org.junit.Assert.assertEquals;
import static utils.Utils.driver;

import java.util.List;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ClockPage {

	public ClockPage(AppiumDriver<?> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='ALARM']")
	private MobileElement botaoAlarme;

	public void acessarMenuAlarme() throws Exception {
		System.out.println("acessando menu alarme");

		botaoAlarme.click();
	}

	@AndroidFindBy(accessibility = "Add alarm")
	private MobileElement botaoAdd;

	public void acionarBotaoNovoAlarme() throws Exception {
		System.out.println("adcionando novo alarme");

		botaoAdd.click();
	}

	@AndroidFindBy(id = "android:id/button1")
	private MobileElement botaoOk;

	public void acionarBotaoOk() throws Exception {

		botaoOk.click();
	}

	@AndroidFindBy(id = "com.google.android.deskclock:id/edit_label")
	private MobileElement campoLabel;

	@AndroidFindBy(xpath = "//android.widget.EditText")
	private MobileElement campoEditText;

	@AndroidFindBy(id = "android:id/button1")
	private MobileElement apertarBotaoOk;

	public void interagirComEditText() throws Exception {

		acessarMenuAlarme();
		acionarBotaoNovoAlarme();

		campoLabel.click();

		campoEditText.sendKeys("novo alarme");

		apertarBotaoOk.click();
	}

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Default (Cesium)']")
	private MobileElement textoCombo;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Barium']")
	private MobileElement opcaoCombo;

	public void interagirComCombo() throws Exception {

		acessarMenuAlarme();
		acionarBotaoNovoAlarme();

		System.out.println("interagindo com o combo");

		textoCombo.click();

		opcaoCombo.click();
	}

	@AndroidFindBy(xpath = "//android.widget.Switch[@text='ON'][1]")
	private MobileElement switchApp;

	public void interagindoComSwitch() throws Exception {
		System.out.println("interagindo com o switch");
		acessarMenuAlarme();
		acionarBotaoNovoAlarme();

		switchApp.click();

		assertEquals("false", switchApp.getAttribute("checked"));
	}

	@AndroidFindBy(xpath = "//android.widget.CheckBox[@text='Repeat'][1]")
	private MobileElement check;

	public void interagindoComCheckBox() throws Exception {

		acessarMenuAlarme();
		acionarBotaoNovoAlarme();

		check.click();

		assertEquals("true", check.getAttribute("checked"));
	}

	public void clicarNaHora(String hora) throws Exception {
		MobileElement clickHora = (MobileElement) driver.findElement(MobileBy.AccessibilityId(hora));
		clickHora.click();

	}

	public void clicarNoMinuto(String minuto) throws Exception {
		MobileElement clickMinuto = (MobileElement) driver.findElement(MobileBy.AccessibilityId(minuto));
		clickMinuto.click();
	}

	public void selecionarOPeriodo(String periodo) throws Exception {

		String periodoModificado = periodo.toLowerCase();

		MobileElement clickPeriodo = (MobileElement) driver
				.findElement(MobileBy.id("android:id/" + periodoModificado + "_label"));
		clickPeriodo.click();
	}
	
	
	public void validarInformacoes(List<String> dados) {
		MobileElement infos;
		for (String info : dados) {
			infos = (MobileElement) driver.findElement(MobileBy.xpath("//*[@text='"+info+"']"));
			System.out.println("Infos tela: " + infos.getText());
			assertEquals(info, infos.getText());
		}
	}
}
