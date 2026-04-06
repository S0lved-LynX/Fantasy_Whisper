package com.app.fantasywhisper.ui

import com.app.fantasywhisper.ui.data.ListData
import com.app.fantasywhisper.ui.data.roleplayItems
import com.app.fantasywhisper.ui.data.kinkItems
import com.app.fantasywhisper.ui.data.cosplayItems
import com.app.fantasywhisper.ui.data.placesItems
import com.app.fantasywhisper.ui.data.roleplayItemsCZ
import com.app.fantasywhisper.ui.data.kinkItemsCZ
import com.app.fantasywhisper.ui.data.cosplayItemsCZ
import com.app.fantasywhisper.ui.data.placesItemsCZ


interface AppStrings {
    val menuTitle: String
    val menuHome: String
    val menuDis: String

    // menu
    val menuText: String
    val menuPointOne: String
    val menuPointTwo: String
    val menuPointThree: String
    val menuPointFour: String
    val menuButton: String
    val menuLangButton: String

    // options
    val optionsTitle: String
    fun numberPeople (number: Int): String
    val buttonKinks: String
    val buttonRoleplays: String
    val buttonCosplays: String
    val buttonPlaces: String
    val buttonBack: String
    val optionsInfo: String

    // disclaimer
    val disBull1: String
    val disBull2: String
    val disBull3: String
    val disBull4: String
    val disBull5: String
    val disBull6: String
    val disPriv: String
    val disGit: String
    val disFeed: String
    val disLiability: String
    val disLink: String
    val disWeb: String
    val searchText: String

    // data
    val kinkData: List<ListData>
    val roleplayData: List<ListData>
    val cosplayData: List<ListData>
    val placesData: List<ListData>

    // list screen
    fun listTitle(index: Int): String

    // result screen
    val resTitle: String
    val resFileName: String
    val resExportButton: String
    val resText: String
    val resEnd: String
    val buttonNext: String
    val buttonResult: String
    val emptyResult: String


    // export
    val expKinks: String
    val expCosplays: String
    val expRoleplays: String
    val expPlaces: String
    val okSave: String
    val badSave: String
    val obsidianInfo: String

    // Warning
    val warnPercent90: String
    val warnPercent99: String
    val warnALL: String
    val warnOKAY: String
    val warnTitle: String
    fun warnText(warning: String): String
    val warnContinue: String

}

object EnglishStrings : AppStrings {
    override val menuTitle = "Welcome"
    override val menuHome= "Home"
    override val menuDis= "Disclaimer"

    // menu
    override val menuText = "Do you want to try something different with your partner and you don't know how to tell them about your desires? Are you a shy person? I built a communication tool for you!"
    override val menuPointOne = "Choose category you want to \"Whisper\""
    override val menuPointTwo = "Fill in your desires privately and then let your partner do the same."
    override val menuPointThree = "See ONLY desires that you both have in common."
    override val menuPointFour = "And communicate what to do with the result. \nNow it might be a bit easier, don't you think so?"
    override val menuButton = "Start Whispering"
    override val menuLangButton = "\uD83C\uDDE8\uD83C\uDDFF Change Language \uD83C\uDDE8\uD83C\uDDFF"

    // options
    override val optionsTitle = "Choose a category"
    override fun numberPeople (number: Int)  = "Select number of people: $number"
    override val buttonKinks = "Kinks"
    override val buttonRoleplays = "Roleplay"
    override val buttonCosplays = "Cosplay"
    override val buttonPlaces = "Places"
    override val buttonBack = "Back"
    override val optionsInfo = "Select your preferences by checking the boxes. Tap any item to see more details."

    // disclaimer
    override val disBull1 = "Consent is mandatory. Never use this app to coerce or force anyone into any activity."
    override val disBull2 = "Privacy Warning: Sharing your desires requires trust. If someone checks all items, they may see your private preferences."
    override val disBull3 = "Content Policy: Illegal or extreme kinks are strictly excluded for safety and legal compliance."
    override val disBull4 = "Safety First: Research and practice safety when exploring high-risk activities."
    override val disBull5 = "Legal Compliance: Users must ensure their activities comply with local laws in their current jurisdiction."
    override val disBull6 = "Age Restriction: This app is strictly for users aged 18+"
    override val disPriv = "Privacy & Data: This software is free and publicly available. It does not collect personal data or require special device permissions to function."
    override val disFeed = "Feedback: I welcome suggestions for updates and new features."
    override val disLiability = "Liability: This software is provided for communication purposes only. The developer assumes no liability for any injury, loss, or damage resulting from the use of this app."
    override val disGit = "Licensed under GNU GPLv3. Available at "
    override val disLink = "The kinks list was taken from this "
    override val disWeb = "website."
    override val searchText = "Search..."


    // data
    override val kinkData = kinkItems
    override val roleplayData = roleplayItems
    override val cosplayData = cosplayItems
    override val placesData = placesItems

    // list screen
    override fun listTitle(index: Int) = "Person #$index"

    // result screen
    override val resTitle = "Result"
    override val resFileName = "Results.md"
    override val resExportButton = "Export Result"
    override val resText = "You both want to try or have in common:"
    override val resEnd = "End Whisper"
    override val buttonNext = "Proceed to next member"
    override val buttonResult = "See results"
    override val emptyResult = "It looks like you don't have anything in common, but don't be sad! Try to communicate with your partner and maybe you will find something you both want to try. Or you can try to negotiate a compromise. \nAfter all this app is about communication, so don't be sad about the result and try to find different solution to make your desires come true.\n\n (And also remember: taste can change!)"


    // export
    override val expKinks = "# You both have those fantasies in common:  "
    override val expCosplays = "# You both fantasize about those cosplays:  "
    override val expRoleplays = "# You both want to try those roleplays:  "
    override val expPlaces = "# You both want to try something on those places:  "
    override val okSave = "Saved successfully!"
    override val badSave = "Failed to save"
    override val obsidianInfo = "Best use with Obsidian md"
    
    // Warning
    override val warnPercent90 = "over 90% of the list"
    override val warnPercent99 = "almost all"
    override val warnALL = "all"
    override val warnOKAY = "error occurred"
    override val warnTitle = "Warning"
    override fun warnText (warning: String) = "Be aware - someone filled $warning of the options in list. They are maybe trying to know all of your fantasies. Do you believe all the people you are using this app with?"
    override val warnContinue = "Yes, I believe them and see results."
}

object CzechStrings : AppStrings {
    override val menuTitle = "Vítej"
    override val menuHome= "Home"
    override val menuDis= "Disclaimer"

    // menu
    override val menuText = "Chceš se svým partnerem vyzkoušet něco nového, ale nevíš, jak mu říct o svých touhách? Jsi stydlivý člověk? Vytvořil jsem pro tebe tento komunikační nástroj!"
    override val menuPointOne = "Vyber si kategorii, kterou si chcete „Pošeptat“"
    override val menuPointTwo = "Soukromě vyplň svá přání a poté nechej partnera udělat totéž."
    override val menuPointThree = "Uvidíte POUZE ty touhy, které máte oba společné."
    override val menuPointFour = "A pak už stačí jen probrat, co s výsledkem podniknete. \nTeď už je to o něco snazší, nemyslíš?"
    override val menuButton = "Začít šeptat"
    override val menuLangButton = "\uD83C\uDDEC\uD83C\uDDE7 Změnit jazyk \uD83C\uDDEC\uD83C\uDDE7"

    // options
    override val optionsTitle = "Vyber si kategorii"
    override fun numberPeople (number: Int)  = "Zvolte počet lidí: $number"
    override val buttonKinks = "Kinky"
    override val buttonRoleplays = "Hraní rolí"
    override val buttonCosplays = "Převleky"
    override val buttonPlaces = "Místa"
    override val buttonBack = "Zpět"
    override val optionsInfo = "Vyberte své preference zaškrtnutím políčka. Kliknutím na název zobrazíte popis."


    // disclaimer
    override val disBull1 = "Souhlas je povinný. Nikdy tuto aplikaci nepoužívej k nátlaku nebo nucení kohokoli k jakékoli aktivitě."
    override val disBull2 = "Varování ohledně soukromí: Sdílení tužeb vyžaduje důvěru. Pokud někdo zaškrtne všechny položky, může uvidět tvé soukromé preference."
    override val disBull3 = "Zásady obsahu: Nelegální nebo extrémní kinky jsou z důvodu bezpečnosti a dodržování zákonů striktně vyloučeny."
    override val disBull4 = "Bezpečnost především: Při zkoumání rizikových aktivit si vždy předem nastudujte pravidla bezpečnosti."
    override val disBull5 = "Právní soulad: Uživatelé musí zajistit, aby jejich aktivity byly v souladu s místními zákony v jejich aktuální jurisdikci."
    override val disBull6 = "Věkové omezení: Tato aplikace je určena výhradně pro uživatele starší 18 let."
    override val disPriv = "Soukromí a data: Tento software je zdarma a veřejně dostupný. Ke svému fungování neshromažďuje osobní údaje ani nevyžaduje zvláštní oprávnění zařízení."
    override val disFeed = "Zpětná vazba: Uvítám návrhy na aktualizace a nové funkce."
    override val disLiability = "Odpovědnost: Tento software je poskytován pouze pro účely komunikace. Vývojář nenese žádnou odpovědnost za jakékoli zranění, ztrátu nebo škodu vzniklou v důsledku používání této aplikace."
    override val disGit = "Licencováno pod GNU GPLv3. Dostupné na "
    override val disLink = "Seznam kinků byl převzat z tohoto "
    override val disWeb = "webu."
    override val searchText = "Hledej..."

    // data
    override val kinkData = kinkItemsCZ
    override val roleplayData = roleplayItemsCZ
    override val cosplayData = cosplayItemsCZ
    override val placesData = placesItemsCZ

    // list screen
    override fun listTitle (index: Int) = "Osoba #$index"

    // result screen
    override val resTitle = "Výsledek"
    override val resFileName = "Vysledky.md"
    override val resExportButton = "Exportovat výsledek"
    override val resText = "Oba chcete vyzkoušet nebo máte společné:"
    override val resEnd = "Ukončit šeptání"
    override val buttonNext = "Pokračovat na dalšího člena"
    override val buttonResult = "Zobrazit výsledky"
    override val emptyResult = "Vypadá to, že nemáte nic společného, ale nebuďte smutní! Zkuste si s partnerem promluvit a možná najdete něco, co chcete zkusit oba. Nebo se můžete zkusit dohodnout na kompromisu. \nTato aplikace je především o komunikaci, tak neklesejte na mysli a zkuste najít jiné řešení, jak si splnit své sny.\n\n (A pamatujte: chutě se mohou měnit!)"

    // export
    override val expKinks = "# Máte společné tyto fantazie:  "
    override val expCosplays = "# Oba sníte o těchto cosplayích:  "
    override val expRoleplays = "# Oba chcete vyzkoušet tyto roleplaye:  "
    override val expPlaces = "# Oba chcete zkusit něco na těchto místech:  "
    override val okSave = "Úspěšně uloženo!"
    override val badSave = "Uložení se nezdařilo"
    override val obsidianInfo = "Nejlépe funguje s aplikací Obsidian md"

    // Warning
    override val warnPercent90 = "přes 90 %"
    override val warnPercent99 = "téměř všechny"
    override val warnALL = "všechny"
    override val warnOKAY = "došlo k chybě"
    override val warnTitle = "Varování"
    override fun warnText (warning: String) = "Pozor – někdo v seznamu vyplnil $warning možností. Možná se snaží zjistit všechny tvé fantazie. Důvěřuješ všem lidem, se kterými tuto aplikaci právě používáš?"
    override val warnContinue = "Ano, důvěřuji jim, zobrazit výsledky."
}