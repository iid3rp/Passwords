import java.util.*;
import java.io.*;



public class arrays
{ 
    public static final String[] stuff =
    {
        /* case 0*/  "Must have at least 20 characters minimum.",  
        /* case 1*/  "Must include a space.",  
        /* case 2*/  "Needs to contain a fruit, but spelled backward.",  
        /* case 3*/  "Your password must reference an animal that's commonly kept as a pet.",  
        /* case 4*/  "Should have a type of bread embedded in it.",  
        /* case 5*/  "Must include a Capital letter.",  
        /* case 6*/  "Must contain the name of a primary color.",  
        /* case 7*/  "Password should reference a common household appliance.",  
        /* case 8*/  "Must have an even number of letters.",  
        /* case 9*/  "Password should start with a consonant and end with a vowel.",  
        /* case 10*/  "Must mention any footwear.",  
        /* case 11*/  "Include the name of a thing that typically comes in pairs.",  
        /* case 12*/  "Password must contain the word of a human organ.",  
        /* case 13*/  "Must include a number divisible by 2.",  
        /* case 14*/  "Password should include a two digit square number.",  
        /* case 15*/  "Needs to have a single-digit prime number.",  
        /* case 16*/  "Must contain an arithmetic operator.",  
        /* case 17*/  "Password should include a common fraction.",  
        /* case 18*/  "Must contain at least random number vowel",  
        /* case 19*/  "Must include at least one punctuation mark",  
        /* case 20*/  "Must start with a consonant.",  
        /* case 21*/  "Password must include the name of any mainstream female pop artist.",  
        /* case 22*/  "Must contain a type of pasta.",  
        /* case 23*/  "Needs to include the name of a berry.",  
        /* case 24*/  "The password should contain three ascending alphabetical letters in a row.",  
        /* case 25*/  "Include a type of cloud.",  
        /* case 26*/  "Password must reference a common kitchen spice.",  
        /* case 27*/  "Must hint at a popular recreational sport.",  
        /* case 28*/  "Should have a word related to a dessert.",  
        /* case 29*/  "Your password needs to have a name of a season.",  
        /* case 30*/  "Should hint at a classical music composer.",  
        /* case 31*/  "Must reference a body of water (e.g., river, lake, pond).",  
        /* case 32*/  "Must contain a color and its opposite from the color wheel.",  
        /* case 33*/  "Include the name of a body of land",  
        /* case 34*/  "Password contains a Phillipine Volcano.",  
        /* case 35*/  "Should incorporate a Phillipine Island.",  
        /* case 36*/  "Include a country.",  
        /* case 37*/  "Password must include the square root symbol.",  
        /* case 38*/  "Should contain an a, b algebraic expression.",  
        /* case 39*/  "Must reference a well-known mathematical constant in words.",  
        /* case 40*/  "Password should have at least one number of the factor of 12.",  
        /* case 41*/  "Must include with three consecutive counting numbers.",  
        /* case 42*/  "Should hint at the first five digits of a famous irrational number.",  
        /* case 43*/  "Must have an even number of characters.",  
        /* case 44*/  "Should contain both a lowercase and an uppercase English letter.",  
        /* case 45*/  "Must include at least two of these symbols: !, @, #, $.",  
        /* case 46*/  "Password must worth 8000 unicode amount.",  
        /* case 47*/  "Password must inlclude a 1000 unicode amount character.",  
        /* case 48*/  "Must reference the name of the world's largest ocean.",  
        /* case 49*/  "Should contain the name of a dish typically eaten for breakfast.",  
        /* case 50*/  "Password should hint at a famous dish from Italy, but not pizza.",  
        /* case 51*/  "The password should include a fake postal address",  
        /* case 52*/  "Your password needs a nod to a famous fictional detective.",  
        /* case 53*/  "Must include a character that's not in the English alphabet.",  
        /* case 54*/  "Password should allude to a famous historical event.",  
        /* case 55*/  "Must contain a word from the title of a Shakespearean play.",  
        /* case 56*/  "Your password needs to have a nod to a natural phenomenon.",  
        /* case 57*/  "Should contain the name of a geometric shape.",  
        /* case 58*/  "Needs to have a hint to a famous scientist.",  
        /* case 59*/  "Must include the name of a gemstone.",  
        /* case 60*/  "Must contain a reference to a prime number greater than 20.",  
        /* case 61*/  "Password should include a mathematical series.",  
        /* case 62*/  "Must have a negative number.",  
        /* case 63*/  "Should include an integral or derivative symbol.",  
        /* case 64*/  "Password must reference a concept from linear algebra.",  
        /* case 65*/  "Must include an inequality character",  
        /* case 66*/  "Cannot start with a letter.",  
        /* case 67*/  "Must have three consecutive letters of the alphabet.",  
        /* case 68*/  "Password should include a ? or ! but not both.",  
        /* case 69*/  "Password must contain more than two vowels in succession.",  
        /* case 70*/  "Password ends with a number where the first number are the number of vowels and next number are the number of consonants in the password.",  
        /* case 71*/  "Must contain a basic equation using regex.",  
        /* case 72*/  "Your password should reference a spicy cuisine.",  
        /* case 73*/  "Must include a character from an old typewriter not present on modern keyboards.",  
        /* case 74*/  "Must contain Binet's Fibonacci Formula.",  
        /* case 75*/  "Should start with a vowel and end with a consonant.",  
        /* case 76*/  "Must contain a famous artist.",  
        /* case 77*/  "Password should contain a word related to ancient mythology.",  
        /* case 78*/  "Should have a keyword in java language",  
        /* case 79*/  "Must contain the name of a planet in the solar system, but not Earth or Mars.",  
        /* case 80*/  "Needs to reference a famous novel's title, but without its vowels.",  
        /* case 81*/  "Password should have an allusion to a famous building",  
        /* case 82*/  "Must have the names of a famous pop star in pop culture.",  
        /* case 83*/  "Name a number 1 song in the billboard hot 100 around 2020-2023",  
        /* case 84*/  "Include a famous actor",  
        /* case 85*/  "Should mention a viral internet trend from 2018.",  
        /* case 86*/  "Password must reference a major sporting event",  
        /* case 87*/  "Include a famous TV series",  
        /* case 88*/  "Password should reference a well-known mathematical theorem or conjecture.",  
        /* case 89*/  "Must include a reference to a famous mathematician",  
        /* case 90*/  "Should contain an ':3' because why not?",  
        /* case 91*/  "Password must hint at a principle from calculus.",  
        /* case 92*/  "Must reference a term related to higher-level mathematics.",  
        /* case 93*/  "Should include a word of a complex geometric shape.",  
        /* case 94*/  "Must include at least one Greek letter",  
        /* case 95*/  "Should have a character sequence that forms a common abbreviation",  
        /* case 96*/  "Requires at least two punctuation marks.",  
        /* case 97*/  "Must start with an uppercase letter but not end with one.",  
        /* case 98*/  "Should contain a combination of a letter, a number, a special character, and a space in sequence.",  
        /* case 99*/  "Must contain the name of female pop artists but backward.",  
        /* case 100*/  "Must contain ten consecutive digits of the first 100 digits of pi.",  
        /* case 101*/  "The password should be formatted as a potential web URL.",  
        /* case 102*/  "Must include a type of chocolate but with all vowels removed.",  
        /* case 103*/  "Should hint at a popular board game, but spelled in reverse.",  
        /* case 104*/  "Must be formatted as a equation for Force",  
        /* case 105*/  "Include a word that references quarantine. but not "quarantine"",  
        /* case 106*/  "Password must contain a term from astrophysics.",  
        /* case 107*/  "Should reference a concept from quantum mechanics.",  
        /* case 108*/  "Must hint at a renowned mathematical theorem.",  
        /* case 109*/  "Password should allude to a cultural tradition from Southeast Asia.",  
        /* case 110*/  "Should contain the name of an filipino indigenous tribe.",  
        /* case 111*/  "Must reference an element from the periodic table, but in reverse.",  
        /* case 112*/  "Must contain an operation of an equation in words.",  
        /* case 113*/  "Password should allude to a concept from abstract algebra.",  
        /* case 114*/  "Must reference a famous unsolved mathematical problem.",  
        /* case 115*/  "Should include a reference to a concept from topology.",  
        /* case 116*/  "Requires a non-Latin script character.",  
        /* case 117*/  "Password needs to include a rare special character.",  
        /* case 118*/  "Must have a musical symbol.",  
        /* case 119*/  "Requires a three-character palindrome sequence.",  
        /* case 120*/  "Password must be 1/3 in CAPITAL LETTERS.",  
        /* case 121*/  "Must contain a recognized scientific formula.",  
        /* case 122*/  "Password should reference a music genre.",  
        /* case 123*/  "Should reference a board game but in Morse code.",  
        /* case 124*/  "Must include a name from BSIT-BTM Students with a Caesar's Cipher shift of 3.",  
        /* case 125*/  "Needs a reference to a Taylor Swift song, but from her Red album, but not \'red\'.",  
        /* case 126*/  "Must contain a shape from gambling cards",  
        /* case 127*/  "Password must allude to a philosophical concept.",  
        /* case 128*/  "Should contain a word that describes an obscure emotion.",  
        /* case 129*/  "Must reference a term from neurobiology.",  
        /* case 130*/  "Must reference a term of linguistic phenomena.",  
        /* case 131*/  "Password should reference a rare meteorological event.",  
        /* case 132*/  "Must contain an item that you might see in an antique shop.",  
        /* case 133*/  "Mention a moon from the planet Jupiter",  
        /* case 134*/  "Password must contain a potential e-mail address.",  
        /* case 135*/  "Reference a biological kingdom in it's scientific name.",  
        /* case 136*/  "Include the name of a famous theorem in science.",  
        /* case 137*/  "Password should reference a zodiac sign",  
        /* case 138*/  "Must contain a college abbreviation.",  
        /* case 139*/  "Should include a term related to programming.",  
        /* case 140*/  "Password must reference a reptile",  
        /* case 141*/  "Must contain a suffix at the end.",  
        /* case 142*/  "Should include a representation of a complex mathematical topic.",  
        /* case 143*/  "Must incorporate a character thats a geometric shape",  
        /* case 144*/  "Must begin and end with a unicode arrow character.",  
        /* case 145*/  "Should include the name of a primary color but replace vowels with digits.",  
        /* case 146*/  "Requires both an opening and closing braces character.",  
        /* case 147*/  "Should contain a word where letters are in alphabetical order.",  
        /* case 148*/  "The Whole password must be a palindrome.",  
        /* case 149*/  "Must include the unique BSIT-BTM Surnames"
    };

    private static final String[] WORDS = 
    {
        // words are for the spellchecker event in the game..,,,
        // Shortest words (3-4 letters)
        "dog", "cat", "moon", "star",
        "sun", "bean", "leaf", "rock",
        "hill", "book", "ball", "shoe",
        "hair", "rain", "wind", "snow",
        "fish", "bird", "clay", "sand",
        "soil", "tree", "root", "ship",
        "boat", "road", "city", "town",
        "desk", "lamp", "coat", "ring",
        "bell", "door", "wall", "key",
        "lock", "fire", "wood", "glass",
        "rice", "milk", "wine", "corn",
        "salt", "gold", "bear", "lion",
        
        // Short words (5-6 letters)
        "planet", "flower", "branch", "castle",
        "valley", "jungle", "island", "desert",
        "forest", "garden", "candle", "butter",
        "cheese", "bread", "apple", "orange",
        "grape", "cherry", "pencil", "eraser",
        "bottle", "mirror", "window", "street",
        "bridge", "tunnel", "beach", "mount",
        "ocean", "office", "school", "church",
        "temple", "palace", "violet", "purple",
        "yellow", "silver", "bronze", "copper",
        "carbon", "stream", "creek", "sunset",
        "sunrise", "spring", "summer", "winter",
        
        // Medium words (7-10 letters)
        "elephant", "umbrella", "chocolate", "strawberry",
        "raspberry", "blueberry", "pineapple", "watermelon",
        "spaghetti", "macaroni", "universe", "continent",
        "landscape", "adventure", "backpack", "notebook",
        "magazine", "newspaper", "sculpture", "painting",
        "portrait", "building", "furniture", "classroom",
        "bathroom", "kitchen", "bedroom", "basement",
        "apartment", "elevator", "escalator", "staircase",
        "balcony", "corridor", "courtyard", "playground",
        "field", "stadium", "auditorium", "cafeteria",
        "restaurant", "cinema", "theater", "gallery",
        "hospital", "pharmacy", "university", "library",
        
        // Long words (11+ letters)
        "refrigerator", "conservatory", "professional", "television",
        "biodiversity", "encyclopedia", "transportation", "architecture",
        "photographer", "electricity", "personality", "relationship",
        "destination", "enlightenment", "opportunity", "astronomical",
        "perspective", "comfortable", "entertainment", "imagination",
        "introduction", "appreciation", "performance", "participation",
        "atmosphere", "enthusiastic", "exploration", "observation",
        "celebration", "determination", "communicate", "independence",
        "philosophy", "manipulation", "expectation", "organization",
        "composition", "vegetarian", "understanding", "presentation",
        "celebrity", "volunteer", "immigration", "qualification",
        "responsible", "availability", "international", "unbelievable",
        
        // Shortest words (3-4 letters) hard
        "ply", "pry", "wiz", "pug", "kip", "flit", "zwie", "quip", "quip", "fry",
        "twig", "skip", "prig", "flop", "jib", "klip", "prig", "plow", "twig", "flog", 
        "blop", "wimp", "mow", "lip", "blip", "mug", "knot", "prow", "flip", "plum",
        "twig", "prog", "jolt", "limp", "jowl", "quip", "wink", "mirk", "plop", "wisp",
        "spry", "pork", "tug", "jimp", "knew", "plum", "prow", "limn", "blow", "writ",
        "plod", "flop", "wisp", "knee", "pork", "plow", "limp", "knit", "wimp", "molt",
        "prod", "plod", "wisp", "knee", "jolt", "jimp", "jowl", "mown", "know", "flog",
        "knob", "blop", "brow", "blow", "skip", "flap", "glum", "twig", "slip", "slug",

        // Short words (5 to 6 letters) hard
        "plumb", "quark", "jumpy", "flint", "wodge", "blink", "prong", 
        "squad", "whelp", "twerp", "flock", "brink", "plush", "twirl", 
        "flank", "brawn", "quips", "krypt", "wizen", "prowl", "sculk", 
        "drift", "whizs", "glumly", "spurt", "shrunk", "whiff", "knack",
        "whomp", "pinks", "jowls", "blitz", "plunks", "squat", "wrung",
        "prink", "whisk", "jilts", "qwerty", "klutz", "wrist", "spry",
        "twixt", "prong", "blimp", "crwth", "junks", "frypan", "gruff",
        "pluck", "prize",
    
        // Medium words (7 to 10 letters) hard
        "jumping", "quizzed", "thwacks", "flanked", "pruning", "blowzy", 
        "twanged", "spruced", "blintze", "quokkas", "flicked", "plowing", 
        "whizzing", "kludges", "sprinkle", "plungers", "whippers", "junkyard", 
        "squelch", "thwarter", "squibbed", "grumbled", "knowable", "squawked",
        "plinkers", "swizzled", "knobbier", "quibbled", "prancing", "frowzily",
        "pritzels", "frisking", "spritzes", "prawned", "squidgy", "knackery",
        "swinked", "thrummer", "plumpers", "skewer", "spurtled", "scrumpox",
        "plinked", "frizzling", "squashed", "klutzier", "jumbling", "prattled",
        "knitters", "pruritus", "whippoor", "squarrose", "krummhorn", "plumlike",
    
        // Long words (11+ letters) hard
        "quantitatively", "blitzkriegs", "subjectively", "unexplainable", 
        "photosynthesize", "quintessentials", "blowtorching", "unjustifiable", 
        "exemplifications", "knowledgeability", "skullduggery", "plumpnesses", 
        "flibbertigibbet", "justifiability", "unknowabilities", "unsquelched",
        "plasterboards", "quicksilvering", "unquestionably", "knuckleballer",
        "quartermasters", "knuckleheaded", "prankishnesses", "kleptomaniacs",
        "practicability", "unscrupulously", "unquenchable", "juxtapositional",
        "justifications", "priggishnesses", "knowledgeably", "exemplifying",
        "unquestioning", "unscrupulous", "unscratched", "unknowingly", 
        "pluckinesses", "pneumokonioses", "kleptocracies", "squirrelfishes", 
        "plutocratically", "quizzicality", "unquestioned", "plausibilities",
        "knowledgeable", "unscratched", "unsquelching", "kittenishness", 
        "kleptomaniacs", "unquestionably", "kleptomaniacal", "quintuplicated",
    };

    public static String[] reversedFruits = 
    {
        "elppa", "ananab", "yrrehc", "etad", "yrrebredle", "gif", "eparg", "wedynoh", "iwik",
        "nomel", "ognam", "eniratcen", "egnaro", "ayapap", "ecniuq", "yrrebpsar", "yrrebwarts",            
        "eniregnat", "ilgu", "tiurfnoissap", "nolemretaw", "yrrebneulb", "eehcyl", "nomsrep",
        "yrrebkcalb", "tocirpa", "odacova", "avaug", "etanargemop", "tiurfwiwik", "tiurfkcaj",
        "tiurfnogard", "raep", "mulp", "hcaep", "yrrebnarc", "emil", "tunococ", "tiurfeparg",
        "tiurfrats", "yrreblum", "yrrebnesyob", "nagnol", "nairud", "surom", "yrrebbil", 
        "yrrebsesoog", "yrrebgninogil", "tnarruc", "yrrebduolc", "yrrebnomlas", "abaticubaj",
        "pouseruos", "nasalup", "taukmuK", "nalobmaj", "ayatip", "raepylkcirp", "aoejif", 
        "neetsognam", "natsurbar", "lotnas", "allidapos", "yrrebmuy", "tnarrucetihW", 
        "tiurfnoissapylluf", "nolemksum", "yrrebkculh"
    };

    public static String[] pets = 
    {
        "dog", "cat", "hamster", "goldfish", "bettafish", "turtle", "rabbit", "guineapig", 
        "bird", "parrot", "cockatiel", "budgerigar", "snake", "lizard", "iguana", "gecko", 
        "chameleon", "ferret", "hedgehog", "tarantula", "rat", "mouse", "gerbil", "salamander", 
        "newt", "frog", "toad", "hermitcrab", "prayingmantis", "stickinsect", "sugarglider",
        "chinchilla", "axolotl", "dove", "pigeon", "conure", "lovebird", "finch", "canary", 
        "africangrey", "macaw", "cockatoo", "beardeddragon", "ballpython", "cornsnake", 
        "boaconstrictor", "kingsnake", "milksnake", "anole", "skink", "monitorlizard"
    };

    public static String[] breads = 
    {
        "baguette", "sourdough", "rye", "ciabatta", "focaccia", "brioche", "pumpernickel", 
        "challah", "naan", "pita", "bagel", "englishmuffin", "croissant", "pretzel", "cornbread", 
        "multigrain", "wheat", "white", "panettone", "stollen", "crumpet", "muffin", "flatbread", 
        "lavash", "tortilla", "matzah", "baghrir", "arepa", "scone", "damper", "zopf", "soda", 
        "batard", "paindecampagne", "paincomplet", "painviennois", "roti", "paratha", "chapati", 
        "tigerbread", "raisinbread", "potatobread", "barabrith", "bannock", "bolillo", "fugasse", 
        "limpa", "marraqueta", "miche", "obwarzanek", "pirozhki", "pullman", "quickbread", "rewena"
    };

    public static String[] appliances =
    {
        "refrigerator", "microwave", "oven", "dishwasher", "washingmachine", "dryer", 
        "vacuumcleaner", "airconditioner", "heater", "blender", "coffeemaker", "toaster", 
        "ricecooker", "electricfan", "television", "tv"
    };

    public static String[] footwear = 
    {
        "sneakers", "sandals", "boots", "heels", 
        "flats", "slippers", "moccasins", "clogs", 
        "loafers", "espadrilles", "wedges", "oxfords", "shoes"
    };

    public static String[] pairedItems = 
    {
        "socks", "shoes", "gloves", "earrings", "eyes",
        "ears", "hands", "feet", "knees", "elbows",
        "nostrils", "speakers", "headphones", "dice", "scissors",
        "skis", "chopsticks", "tweezers", "sunglasses", "paddles",
        "drumsticks", "wings", "oars", "crutches", "lungs",
        "kidneys", "bookends", "braces", "needles", "laces",
        "mittens", "turntables", "goggles", "pedals", "hinges",
        "castanets", "batteries", "covers", "cufflinks", "plugs",
        "tongs", "pliers", "sandals", "bells", "forks",
        "legs", "wheels", "pistons", "binoculars", "doors",
        "fins", "plugs", "boxes", "tickets", "duelists",
        "wipers", "sheets", "skates", "shutters", "flippers",
        "slippers", "knobs", "buttons", "handles", "levers",
        "boots", "rollers", "sleeves", "rings", "lenses",
        "candles", "skewers", "clamps", "bridles", "muffs"
    };

    public static String[] humanOrganArray = 
    {
        "brain", "brains", "heart", "hearts", "lung", "lungs",
        "liver", "livers", "spleen", "spleens", "stomach", "stomachs", 
        "kidney", "kidneys", "intestine", "intestines", "pncreas", "pancreases", 
        "bladder", "bladders", "appendix", "appendices", "esophagus", "esophagi", 
        "gallbladder", "gallbladders", "thyroid", "thyroids", "trachea", "tracheae", 
        "adrenal", "adrenals", "duodenum", "duodenums", "colon", "colons", 
        "rectum", "rectums", "prostate", "prostates", "ovary", "ovaries", 
        "testis", "testes", "uterus", "uteri", "skin", "skins",
        "muscle", "muscles", "bone", "bones", "eye", "eyes", 
        "ear", "ears", "nose", "noses", "tongue", "tongues"
    };    

    public static char[] punctuation = 
    {
        '.', ',', ':', ';', '!', '?', '-', '\u2014', '\u2013', '(',
        ')', '{', '}', '[', ']', '<', '>', '\\', '/', '|',
        '&', '@', '#', '$', '%', '^', '*', '+', '=',
        '~', '`', '"', '\'', '\u2026',
        '(', ')', '{', '}', '[', ']', '<', '>', '&', '@', '#', '$', '%', '^', '*', '+', '='
        // Add more punctuation characters as needed
    };

    public static String[] femalePopArtists =
    {
        "adele", "arianagrande", "beyonce", "billieeilish",
        "britneyspears", "camilacabello", "cardib", "carlyraejepsen",
        "celinedion", "cher", "christinaaguilera", "demilovato",
        "dualipa", "elliegoulding", "halsey", "janetjackson",
        "katyperry", "kesha", "ladygaga", "lanadelrey",
        "lorde", "madonna", "mariahcarey", "meghantrainor",
        "miley", "nickiminaj", "pink", "rihanna",
        "selenagomez", "shakira", "taylorswift", "whitneyhouston"
    };

    public static String[] pastaTypes =
    {
        "agnolotti", "bucatini", "cannelloni", "capellini",
        "casarecce", "cavatappi", "cavatelli", "conchiglie",
        "farfalle", "fettuccine", "fusilli", "gnocchi",
        "lasagna", "linguine", "macaroni", "manicotti",
        "orzo", "paccheri", "pappardelle", "penne",
        "ravioli", "rigatoni", "rotini", "spaghetti",
        "tagliatelle", "tortellini", "trofie", "vermicelli",
        "ziti"
    };

    public static String[] berryTypes =
    {
        "acai", "barberry", "blackberry", "blueberry",
        "boysenberry", "cloudberry", "cranberry", "currant",
        "dewberry", "elderberry", "goji", "gooseberry",
        "huckleberry", "juniperberry", "loganberry", "mulberry",
        "raspberry", "salmonberry", "strawberry", "tayberry"
    };

    public static String[] cloudTypes =
    {
        "altocumulus", "altostratus", "cirrocumulus", "cirrostratus",
        "cirrus", "cumulonimbus", "cumulus", "nimbostratus",
        "stratocumulus", "stratus", "mammatus", "lenticular",
        "contrail", "kelvinhelmholtz", "nacreous", "noctilucent",
        "pileus", "roll", "wall"
    };

    public static String[] kitchenSpices =
    {
        "basil", "pepper", "cardamom", "cayenne",
        "cinnamon", "cloves", "coriander", "cumin",
        "dill", "fennel", "garlic", "ginger",
        "mint", "nutmeg", "oregano", "paprika",
        "parsley", "rosemary", "saffron", "sage",
        "thyme", "turmeric", "vanilla"
    };

    public static String[] recreationalSports =
    {
        "soccer", "basketball", "tennis", "volleyball",
        "baseball", "softball", "badminton", "golf",
        "swimming", "cycling", "running", "tabletennis",
        "bowling", "hiking", "skiing", "snowboarding",
        "rockclimbing", "surfing", "kayaking", "sailing",
        "skateboarding", "frisbee", "yoga", "dance",
        "martialarts", "rollerblading", "horsebackriding", "archery"
    };

    public static String[] dessertWords =
    {
        "sweet", "chocolate", "cake", "pie",
        "pudding", "tart", "custard", "gelato",
        "icecream", "brownie", "cookie", "mousse",
        "fudge", "cupcake", "donut", "sorbet", "creme",
        "cheesecake", "pastry", "truffle", "meringue",
        "fruit", "sugar", "caramel", "whippedcream",
        "sprinkles", "frosting", "filling", "topping",
        "syrup", "jam", "jelly", "compote"
    };

    public static String[] classicalComposers =
    {
        "bach", "beethoven", "mozart", "chopin",
        "vivaldi", "tchaikovsky", "handel", "wagner",
        "verdi", "brahms", "haydn", "schubert",
        "liszt", "stravinsky", "debussy", "rachmaninoff",
        "mahler", "mendelssohn", "grieg", "sibelius",
        "rossini", "dvorak", "shostakovich", "bartok",
        "satie", "rimskykorsakov", "saintsaens", "ravel"
    };

    public static String[] bodiesOfWater =
    {
        "ocean", "sea", "lake", "river",
        "pond", "stream", "creek", "bay",
        "lagoon", "fjord", "canal", "reservoir",
        "estuary", "delta", "gulf", "harbor",
        "marsh", "swamp", "waterfall", "brook",
        "channel", "strait", "reef", "rapids",
        "pool", "basin", "bayou", "sound"
    };

    public static String[] bodiesOfLand =
    {
        "continent", "island", "peninsula", "isthmus",
        "plateau", "mountain", "hill", "valley",
        "prairie", "steppe", "tundra", "canyon",
        "gorge", "dune", "desert", "oasis",
        "mesa", "butte", "volcano", "crater",
        "plain", "taiga", "rainforest", "marsh",
        "bog", "swamp", "delta", "savanna",
        "badland", "glacier", "ridge", "cliff",
        "fjord", "gully", "knoll", "glen",
        "cave", "cavern", "jungle", "forest",
        "moor", "heath", "meadow", "grove",
        "beach", "coast", "cape", "archipelago"
    };

    public static String[] philippineVolcanoes =
    {
        "taal", "mayon", "pinatubo", "kanlaon", "bulusan", 
        "hibok-hibok", "iriga", "isarog", "banahaw", "makiling",
        "musuan", "parker", "ragang", "smith", "biliran",
        "buddajo", "dajo", "cagua", "camiguin", "didicas", "iloilo"
    };

    public static String[] philippineIslands = 
    {
        // considering the amount of islnads in the phillipines,
        // i dont think i can put them all tbh djklfhsjkfh
        // Luzon
        "luzon", "mindoro", "palawan", "catanduanes", "marinduque", 
        "romblon", "batan", "sabtang", "calayan", "camiguin", 
        "polillo", "alabat", "burias", "tablas", "sibuyan",
        "ticao", "batanes", "masbate", "bicol", 
    
        // Visayas
        "panay", "cebu", "bohol", "siquijor", "guimaras", 
        "negros", "samar", "leyte", "biliran", "bantayan", 
        "camotes", "panglao", "boracay", "malapascua", "olango", 
        "homonhon", "capul", "ticao", "pescador", "danjugan",
        
        // Mindanao
        "mindanao", "dinagat", "siargao", "samal", 
        "basilan", "tawitawi", "sulu", "jolo", 
        "olutanga", "balut", "bucasgrande", "britania", 
        "sarangani", "limasawa", "littlesantacruz", "greatsantacruz", 
        "laong", "pangutaran", "budbuda", "sibutu", 
        "tapul", "lugus", "pata", "hadji", 
        "panglima", "tandubas", "sitangkai", "cagayandeoro",
        "zamboanga", "davao", "butuan", "gensan", 
        "cotabato", "surigao", "pagadian", "dipolog", 
        "marawi", "iligan", "cdo", "ozamiz", 
        "mati", "tagum", "koronadal", "kidapawan"  
    };

    public static String[] countries = 
    {
        "afghanistan", "albania", "algeria", "andorra", "angola",
        "antiguaandbarbuda", "argentina", "armenia", "australia", "austria",
        "azerbaijan", "bahamas", "bahrain", "bangladesh", "barbados",
        "belarus", "belgium", "belize", "benin", "bhutan",
        "bolivia", "bosniaandherzegovina", "botswana", "brazil", "brunei",
        "bulgaria", "burkinafaso", "burundi", "caboverde", "cambodia",
        "cameroon", "canada", "centralafricanrepublic", "chad", "chile",
        "china", "colombia", "comoros", "congo", "costarica",
        "cotedivoire", "croatia", "cuba", "cyprus", "czechia",
        "denmark", "djibouti", "dominica", "dominicanrepublic", "ecuador",
        "egypt", "elsalvador", "equatorialguinea", "eritrea", "estonia",
        "eswatini", "ethiopia", "fiji", "finland", "france", "gabon", "gambia", "georgia", "germany",
        "ghana", "greece", "grenada", "guatemala", "guinea",
        "guinea-bissau", "guyana", "haiti", "honduras", "hungary",
        "iceland", "india", "indonesia", "iran", "iraq",
        "ireland", "israel", "italy", "jamaica", "japan",
        "jordan", "kazakhstan", "kenya", "kiribati", "kosovo",
        "kuwait", "kyrgyzstan", "laos", "latvia", "lebanon",
        "lesotho", "liberia", "libya", "liechtenstein", "lithuania",
        "luxembourg", "madagascar", "malawi", "malaysia", "maldives",
        "mali", "malta", "marshallislands", "mauritania", "mauritius",
        "mexico", "micronesia", "moldova", "monaco", "mongolia",
        "montenegro", "morocco", "mozambique", "myanmar", "namibia",
        "nauru", "nepal", "netherlands", "newzealand", "nicaragua",
        "niger", "nigeria", "northkorea", "northmacedonia", "norway",
        "oman", "pakistan", "palau", "palestine", "panama",
        "papuanewguinea", "paraguay", "peru", "philippines", "poland",
        "portugal", "qatar", "romania", "russia", "rwanda",
        "saintkittsandnevis", "saintlucia", "saintvincentandthegrenadines", "samoa", "sanmarino",
        "saotomeandprincipe", "saudiarabia", "senegal", "serbia", "seychelles",
        "sierraleone", "singapore", "slovakia", "slovenia", "solomonislands",
        "somalia", "southafrica", "southkorea", "southsudan", "spain",
        "srilanka", "sudan", "suriname", "sweden", "switzerland",
        "syria", "taiwan", "tajikistan", "tanzania", "thailand",
        "timor-leste", "togo", "tonga", "trinidadandtobago", "tunisia",
        "turkey", "turkmenistan", "tuvalu", "uganda", "ukraine",
        "unitedarabemirates", "unitedkingdom", "unitedstates", "usa", "uruguay", "uzbekistan",
        "vanuatu", "vaticancity", "venezuela", "vietnam", "yemen",
        "zambia", "zimbabwe"
    };
    
    public static void main(String[] args)
    {
        try (BufferedWriter w = new BufferedWriter(new FileWriter("h.txt"))) {
            for (int i = 0; i < stuff.length; i++) {
                w.write("/* case " + i + "*/  \"" + stuff[i] + "\",  ");
                w.newLine();
            }
            // some stuff here
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
