import { PollOption } from "../models/PollOption";
import { PollResult } from "../models/PollResult";
import { PollState } from "../models/PollState";

export class PollService {
    private readonly baseUrl = process.env.REACT_APP_POLLSYSTEM_API_URL;

    public async getActivePoll() : Promise<PollState> {
        return new Promise<PollState>((resolve, reject)=> {
            fetch(`${this.baseUrl}/api/poll`)
                .then(res => res.json())
                .then(data => {
                    let pollOptions = <any[]>data.options;
                    let optionsData: PollOption[] = [];

                    for (let o of pollOptions) {
                        optionsData.push({
                            optionId: o.id,
                            value: o.value
                        });
                    }

                    resolve(
                        { 
                            currentPollId: data.currentPollId, 
                            optionSelected: "",
                            subject: data.subject, 
                            isPollCompleted: false,
                            options: optionsData,
                            results: []
                        }
                    );
                })
            .catch(err => reject(err));
        });
    }

    public async votePoll(selectedOptionId: string): Promise<boolean> {
        return new Promise<boolean>((resolve, reject) => {
            fetch(`${this.baseUrl}/api/poll/result`, { 
                method: 'POST', 
                mode: 'cors', 
                headers: {"Content-type": "application/json"},
                body: JSON.stringify({ pollOptionId: selectedOptionId })
            }).then(() => resolve(true))
            .catch(err => reject(err))
        });
    }

    public async loadPollResults(pollId: string): Promise<PollResult[]> {
        return new Promise<PollResult[]>((resolve, reject) => {
            fetch(`${this.baseUrl}/api/poll/results/${pollId}`)
                .then(res => res.json())
                .then(data => {
                   resolve(<PollResult[]>data);
                }).catch(err => reject(err))
        });
    }
}