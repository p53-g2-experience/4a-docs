from dictionaryApp.models.word import Word
from rest_framework import serializers
import datetime

class WordSerializer(serializers.ModelSerializer):

    class Meta:
        model = Word
        fields = '__all__'

    def create(self, validated_data):
        validated_data["creation_date"] = datetime.datetime.now()
        WordInstance = Word.objects.create(**validated_data)

        return WordInstance
    
    def update(self, wordInstance, validated_data):   

        wordInstance.Word = validated_data.get('Word',wordInstance.Word)
        wordInstance.morfo = validated_data.get('morfo',wordInstance.morfo)
        wordInstance.morfema = validated_data.get('morfema',wordInstance.morfema)
        wordInstance.translation = validated_data.get('translation',wordInstance.translation)
        wordInstance.lexical_translation = validated_data.get('lexical_translation',wordInstance.lexical_translation)
        wordInstance.observations = validated_data.get('observations',wordInstance.observations)
        wordInstance.last_modification = datetime.datetime.now()   

        wordInstance.save()
        return wordInstance
         

    def to_representation(self, obj):
    
        wordInstance = Word.objects.get(id = obj.id)
       
        return{
            "id": wordInstance.id,
            "Word": wordInstance.Word,
            "morfo": wordInstance.morfo,
            "morfema": wordInstance.morfema,
            "translation": wordInstance.translation,
            "lexical_translation": wordInstance.lexical_translation,
            "observations": wordInstance.observations,
#            "user_responsible": {
#                        "id": userInstance.id,
#                        "name": userInstance.name
#                    },
        }


    
